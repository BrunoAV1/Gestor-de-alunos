package br.com.alunos.gestao_alunos.controller;

import br.com.alunos.gestao_alunos.model.Aluno;
import br.com.alunos.gestao_alunos.service.AlunoService; // Importe o Service
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService; // <<< MUDANÇA 1: Injetamos o Service, não mais o Repository.

    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("listaAlunos", alunoService.listarTodos()); // Usa o Service
        return "alunos";
    }

    @GetMapping("/novo")
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }
    
    // <<< MUDANÇA 2: O método salvar foi completamente atualizado
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute @Valid Aluno aluno, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        
        // Validação de negócio: verifica se o e-mail já existe
        if (alunoService.emailJaExiste(aluno.getEmail(), aluno.getId())) {
            bindingResult.rejectValue("email", "error.aluno", "Este e-mail já está cadastrado.");
        }

        // Se houver erros de validação (@NotEmpty, etc.) ou o erro de e-mail duplicado...
        if (bindingResult.hasErrors()) {
            // ...retorna para a página do formulário para exibir os erros.
            return "form-aluno";
        }

        // Se passou por todas as validações, salva usando o serviço
        alunoService.salvar(aluno);
        
        // Adiciona uma mensagem de sucesso para ser exibida na página de listagem
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Aluno salvo com sucesso!");
        
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model) {
        // Usa o Service para buscar o aluno
        Aluno aluno = alunoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Aluno inválido:" + id));
        model.addAttribute("aluno", aluno);
        return "form-aluno";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        alunoService.excluir(id); // Usa o Service para excluir
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Aluno excluído com sucesso!");
        return "redirect:/alunos";
    }

    @GetMapping("/exportar-excel")
    public void exportarParaExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=lista_de_alunos.xlsx";
        response.setHeader(headerKey, headerValue);

        
        List<Aluno> alunos = alunoService.listarTodos();

        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Alunos");

        
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Nome", "Email", "Curso"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);

        }


        int rowNum = 1;
        for (Aluno aluno : alunos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(aluno.getId());
            row.createCell(1).setCellValue(aluno.getNome());
            row.createCell(2).setCellValue(aluno.getEmail());
            row.createCell(3).setCellValue(aluno.getCurso());
        }
        
        
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}

