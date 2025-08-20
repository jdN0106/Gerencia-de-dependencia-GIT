**Exercicio-Dependencia**
Descrição do Projeto: Segunda versão da descrição do projeto.

**Descrição do Projeto**
Este é um projeto simples em Java criado para demonstrar os conceitos de gerenciamento de dependências e automação de build utilizando o Apache Maven.

O programa utiliza a biblioteca externa joda-time para obter e formatar a data e a hora atuais, imprimindo o resultado no console. O principal objetivo é ilustrar como o Maven resolve dependências, compila o código e gera um artefato final executável (.jar).


**Pré-requisitos**
Antes de começar, garanta que você tenha as seguintes ferramentas instaladas e configuradas no seu sistema:

JDK (Java Development Kit) - Versão 21 ou superior.
Apache Maven - Versão 3.9 ou superior.


**Git**
**Como Configurar e Executar**
Siga as instruções abaixo para clonar, construir e executar o projeto.


**1. Clonar o Repositório**
Abra o seu terminal e clone o repositório para a sua máquina local:

git clone https://github.com/jdN0106/Gerencia-de-dependencia-GIT
cd Exercicio-Dependencia


**2. Construir o Projeto (Build)**
O Maven cuidará de todo o processo de download de dependências e compilação. Execute o seguinte comando na raiz do projeto:

mvn clean package

Este comando irá:

Limpar compilações anteriores (pasta target).

Baixar a dependência joda-time.

Compilar o código-fonte.

Gerar um arquivo .jar executável dentro da pasta target.

**3. Executar o Programa**
Após o build ser concluído com sucesso, execute o programa com o seguinte comando:

java -jar target/Exercicio-Dependencia-1.0-SNAPSHOT-jar-with-dependencies.jar

A saída no console deverá ser semelhante a esta:

Data atual: 19/08/2025
Hora atual: 18:10:00
O projeto foi construído e as dependências foram resolvidas com sucesso!
