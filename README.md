# Sistema de Gestão de Alunos
Este é um sistema web completo para a gestão de alunos, desenvolvido como um projeto pessoal para demonstrar habilidades em desenvolvimento backend com Java e o ecossistema Spring. A aplicação implementa todas as operações de um CRUD (Create, Read, Update, Delete) e inclui funcionalidades avançadas para garantir uma experiência de usuário robusta e profissional.<br>
O sistema foi construído seguindo as melhores práticas de desenvolvimento, como a separação de responsabilidades em camadas (Controller, Service, Repository), validação de dados no backend e frontend, e tratamento de exceções centralizado.



### ✨ Funcionalidades Implementadas
---
O projeto vai além de um CRUD básico, incluindo:
 * Gestão Completa de Alunos:
   * <strong>Criação:</strong> Adicionar novos alunos ao sistema.
   * <strong>Leitura:</strong> Visualizar a lista completa de alunos cadastrados.
   * <strong>Atualização:</strong> Editar informações de alunos existentes.
   * <strong>Exclusão:</strong> Remover alunos do sistema.
* Validação de Dados Avançada:
    * Validação de campos obrigatórios (nome, e-mail, curso).
    * Validação de formato de e-mail.
    * Validação de negócio para impedir o cadastro de e-mails duplicados, com feedback claro para o usuário.
* Exportação para Excel:
    * Funcionalidade para exportar a lista completa de alunos para um arquivo .xlsx, utilizando a biblioteca Apache POI.
* Interface Amigável:
    * Layout responsivo e moderno construído com Bootstrap 5.
    * Navegação consistente com um layout de template principal (header e footer).
    * Feedback visual para o usuário (mensagens de sucesso e erro).
* Tratamento de Erros Profissional:
    * Páginas de erro personalizadas para exceções comuns (como recurso não encontrado - 404), evitando a "Whitelabel Error Page" padrão do Spring.

---
### 🛠️ Tecnologias Utilizadas
---
Este projeto foi construído com um stack de tecnologias moderno e amplamente utilizado no mercado:
* Backend:
    * <strong>Java 21 (LTS)</strong>
    * <strong>Spring Boot:</strong> Framework principal para a criação da aplicação.
    * <strong>Spring Web:</strong> Para a criação de controladores e endpoints web.
    * <strong>Spring Data JPA:</strong> Para a camada de persistência de dados.
    * <strong>Hibernate:</strong> Implementação do JPA (ORM).
    * <strong>Spring Boot Validation:</strong> Para a validação de dados.
* Frontend:
    * <strong>Thymeleaf:</strong> Motor de templates para renderização de páginas HTML no lado do servidor.
    * <strong>Bootstrap 5:</strong> Framework CSS para a criação de um design responsivo e moderno.
* Banco de Dados:
    * <strong>H2 Database:</strong> Banco de dados em memória para o ambiente de desenvolvimento e testes.
      
* Build e Dependências:
    * <strong>Maven:</strong> Gerenciador de dependências e build do projeto.
    * <strong>Apache POI</strong> Biblioteca para a criação e manipulação de arquivos Excel.
* DevOps:
    * <strong>Git & GitHub:</strong> Para controle de versão e hospedagem do código-fonte.
    * <strong>Render:</strong> Plataforma de nuvem (PaaS) para o deploy contínuo da aplicação e do banco de dados.
---
### 🚀 Como Executar o Projeto Localmente
---
Para executar este projeto em seu ambiente de desenvolvimento, siga os passos abaixo:

1. Pré-requisitos: 
    * Java JDK 21.
    * Maven.
    * Git instalado.
    * Sua IDE preferida (projeto testado apenas no Visual Studio Code)
2. Clone o repositório:

```
git clone https://github.com/BrunoAV1/Gestor-de-alunos.git
```
3. Execute a aplicação:
    * Abra o projeto na sua IDE.
    * Aguarde o Maven baixar todas as dependências (se a IDE não fizer isso automaticamente, recarregue o projeto Maven).
    * Encontre e execute a classe principal GestaoAlunosApplication.java.
4. Acesse a aplicação:
    * Abra seu navegador e acesse: http://localhost:8080/alunos
---

    
