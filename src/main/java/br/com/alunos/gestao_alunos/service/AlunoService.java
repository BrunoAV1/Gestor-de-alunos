package br.com.alunos.gestao_alunos.service;

import br.com.alunos.gestao_alunos.model.Aluno;
import br.com.alunos.gestao_alunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void salvar(Aluno aluno) {

        alunoRepository.save(aluno);
    }

    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public boolean emailJaExiste(String email, Long idAtual) {
        Optional<Aluno> alunoExistente = alunoRepository.findByEmail(email);

        if (alunoExistente.isEmpty()) {
            return false;
        }

        if (idAtual != null && alunoExistente.get().getId().equals(idAtual)) {
            return false;
        }
        
        return true;
    }
}