# Pipeline de CI/CD para Aplicação Java com GitHub Actions

Este projeto demonstra a criação de um pipeline de CI/CD para uma aplicação Java, utilizando Apache Maven para gerenciamento, JUnit/Mockito para testes e GitHub Actions para automação completa do ciclo de desenvolvimento.

O código foi estruturado com boas práticas como injeção de dependência, permitindo uma suíte de testes robusta com mais de 20 cenários que validam a lógica de negócio de forma isolada.

## ✨ Tecnologias Utilizadas
* **Java** (JDK 11+)
* **Apache Maven** (para gerenciamento de dependências e build do projeto)
* **JUnit 4 & Mockito** (para a criação e simulação dos testes unitários)
* **GitHub Actions** (para automação do pipeline de CI/CD)
* **Python** (para o script de notificação por e-mail)

## ⚙️ Pré-requisitos
Antes de começar, garanta que você tenha os seguintes softwares instalados:

* **Java Development Kit (JDK)** - Versão 11 ou superior.
* **Apache Maven** - Versão 3.6 ou superior.

## 🚀 O Pipeline de CI/CD
O coração deste projeto é o workflow de automação configurado no GitHub Actions. Ele é acionado a cada `push` na branch `main` e executa 3 jobs em sequência:

### 🧪 Job de Testes (test)
* Executa a suíte completa com mais de 20 testes unitários.
* Gera um relatório de testes em HTML e o salva como um artefato para análise.

### 📦 Job de Build (build)
* Somente é executado se os testes passarem.
* Compila o código e empacota a aplicação em um arquivo `.jar` executável.
* Salva o `.jar` final como um artefato.


### 📧 Job de Notificação (notify)
* Somente é executado se o build for bem-sucedido.
* Roda um script Python que envia um e-mail de notificação de sucesso.
* As credenciais de e-mail são lidas de forma segura a partir dos Secrets do repositório.

* <img width="635" height="172" alt="image" src="https://github.com/user-attachments/assets/da6e5288-3044-4642-ad5d-ffdb5df36286" />

## ▶️ Como Executar Localmente
1.  Clone o repositório para a sua máquina local:
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd nome-do-projeto
    ```
3.  Use o Maven para compilar o projeto e rodar os testes:
    ```bash
    mvn clean package
    ```
    Este comando irá baixar as dependências, compilar o código, executar os testes e empacotar a aplicação.

4.  Para executar a aplicação, utilize o seguinte comando:
    ```bash
    java -jar target/Exercicio-Dependencia-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```
    A saída no console será a saudação correspondente à hora atual do seu sistema.w
