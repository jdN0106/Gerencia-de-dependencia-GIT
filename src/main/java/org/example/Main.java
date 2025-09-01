package org.example;

public class Main {
    public static void main(String[] args) {

        DateTimeProvider provider = new DateTimeProvider();
        GreetingGenerator generator = new GreetingGenerator(provider);
        String greeting = generator.generateGreetingByTimeOfDay();

        System.out.println(greeting);
    }
}