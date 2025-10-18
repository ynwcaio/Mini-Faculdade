# 🎓 API de Gestão Acadêmica Simples (Cursos e Alunos)

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para gerenciar o relacionamento entre Cursos (`Course`) e Alunos (`Student`). O objetivo principal é praticar e consolidar conceitos avançados do **Spring Data JPA**, especialmente o relacionamento **One-to-Many**.

## 💻 Tecnologias Utilizadas

* **Linguagem:** Java 22
* **Framework:** Spring Boot 3.3.x (Compatível com Spring 3.5.6)
* **Persistência:** Spring Data JPA (Hibernate)
* **Banco de Dados (Desenvolvimento):** H2 Database (Em memória, para testes rápidos)
* **Banco de Dados (Produção):** PostgreSQL (Simulando o ambiente final)
* **Padrão:** RESTful API (CRUD Completo)

## 🏗️ Arquitetura do Projeto

O projeto segue a arquitetura em camadas padrão do Spring Boot:

| Camada | Função | Anotação |
| :--- | :--- | :--- |
| **Entity** | Mapeamento das tabelas (`Course` e `Student`) e definição dos relacionamentos. | `@Entity` |
| **Repository** | Interface que herda os métodos CRUD do JPA para comunicação direta com o DB. | `@Repository` / `JpaRepository` |
| **Service** | **Regra de Negócio.** Contém a lógica de validação e processamento de dados (Ex: "Matricular o aluno no curso X"). | `@Service` |
| **Controller** | **API REST.** Recebe as requisições HTTP e devolve as respostas. | `@RestController` |

## 🔗 Entidades e Relacionamento JPA

O núcleo do projeto é o relacionamento entre as duas entidades:

### `Course` (O Lado "Um")

* **Chave Principal:** `id`
* **Relacionamento:** `@OneToMany(mappedBy = "course")`
* **Regra:** Um Curso pode ter Muitos Alunos.

### `Student` (O Lado "Muitos")

* **Chave Principal:** `id`
* **Relacionamento:** `@ManyToOne` e `@JoinColumn(name = "course_id")`
* **Regra:** Um Aluno pertence a Um Curso.

## 🛠️ Como Executar o Projeto

### Pré-Requisitos

* JDK 22 instalado.
* Maven ou Gradle (para gerenciamento de dependências).

### 1. Clonar o Repositório

```bash
git clone("https://github.com/ynwcaio/Mini-Faculdade")
