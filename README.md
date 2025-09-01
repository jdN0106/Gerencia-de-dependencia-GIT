# Gerenciamento de Dependências com Maven e Testes Unitários

Este projeto é um exemplo simples em Java para demonstrar os conceitos de gerenciamento de dependências com Apache Maven e a importância dos testes unitários com JUnit e Mockito.

O código foi refatorado para seguir boas práticas de desenvolvimento, como a separação de responsabilidades e a injeção de dependências, permitindo que a lógica de negócio seja testada de forma isolada.

## ✨ Tecnologias Utilizadas

- **Java** (JDK 11+)
- **Apache Maven** (para gerenciamento de dependências e build do projeto)
- **Joda-Time** (biblioteca externa para manipulação de data e hora)
- **JUnit 4** (framework para a criação dos testes unitários)
- **Mockito** (framework para a criação de "mocks" ou simulações de dependências nos testes)

## ⚙️ Pré-requisitos

Antes de começar, garanta que você tenha os seguintes softwares instalados:
- **Java Development Kit (JDK)** - Versão 11 ou superior.
- **Apache Maven** - Versão 3.6 ou superior.

## 🚀 Como Compilar e Testar o Projeto

1.  Clone o repositório para a sua máquina local:
    ```bash
    git clone https://github.com/SEU-USUARIO/Gerencia-de-dependencia-GIT.git
    cd Gerencia-de-dependencia-GIT
    ```
2.  Use o Maven para compilar o projeto e rodar a suíte de testes unitários:
    ```bash
    mvn clean package
    ```
    Este comando irá baixar as dependências, compilar o código, executar os 10 testes que criamos e, se tudo passar, empacotar a aplicação em um arquivo `.jar`.

## ▶️ Como Executar a Aplicação

Após o comando `mvn clean package` ser executado com sucesso, um artefato executável será gerado na pasta `target/`.

Para executar o programa, utilize o seguinte comando no seu terminal:

```bash
java -jar target/Exercicio-Dependencia-1.0-SNAPSHOT-jar-with-dependencies.jar
```

A saída no console será a saudação correspondente à hora atual do seu sistema. Por exemplo:

```
Boa noite! A data e hora atuais são: ############
```
