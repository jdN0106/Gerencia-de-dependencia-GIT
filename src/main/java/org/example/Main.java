package org.example;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        DateTime dataAtual = new DateTime();

        DateTimeFormatter formatadorData = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTimeFormatter formatadorHora = DateTimeFormat.forPattern("HH:mm:ss");

        System.out.println("Data atual: " + formatadorData.print(dataAtual));
        System.out.println("Hora atual: " + formatadorHora.print(dataAtual));

        System.out.println("O projeto foi construído e as dependências foram resolvidas com sucesso!");
    }
}