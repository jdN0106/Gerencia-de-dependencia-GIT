package org.example;
import org.joda.time.DateTime;


public class GreetingGenerator {

    private final DateTimeProvider dateTimeProvider;

    public GreetingGenerator(DateTimeProvider provider) {
        if (provider == null) {
            throw new IllegalArgumentException("O provedor de data não pode ser nulo.");
        }
        this.dateTimeProvider = provider;
    }


    public String generateGreetingByTimeOfDay() {
        DateTime now = dateTimeProvider.getCurrentDateTime();

        if (now == null) {
            throw new IllegalStateException("A data recebida do provedor é nula.");
        }

        if (now.getYear() < 1970) {
            throw new IllegalArgumentException("Datas anteriores a 1970 não são suportadas.");
        }

        String timeGreeting;
        int hour = now.getHourOfDay();

        if (hour >= 6 && hour < 12) {
            timeGreeting = "Bom dia!";
        } else if (hour >= 12 && hour < 18) {
            timeGreeting = "Boa tarde!";
        } else {
            timeGreeting = "Boa noite!";
        }

        return timeGreeting + " A data e hora atuais são: " + now.toString("dd/MM/yyyy HH:mm:ss");
    }
}