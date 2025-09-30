package org.example;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GreetingGeneratorTest {

    @Mock
    private DateTimeProvider provider;

    @InjectMocks
    private GreetingGenerator generator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private String formatExpected(String greeting, DateTime dateTime) {
        return greeting + " A data e hora atuais são: " + dateTime.toString("dd/MM/yyyy HH:mm:ss");
    }

    // --- Testes para o Período da MANHÃ ---

    // Testa o início da manhã, exatamente às 06:00.
    @Test
    public void deveRetornarBomDiaExatamenteAs06h() {
        DateTime time = new DateTime(2025, 9, 29, 6, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Bom dia!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um minuto após o início da manhã.
    @Test
    public void deveRetornarBomDiaUmMinutoAposAs06h() {
        DateTime time = new DateTime(2025, 9, 29, 6, 1, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Bom dia!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um horário no meio da manhã.
    @Test
    public void deveRetornarBomDiaAs10h() {
        DateTime time = new DateTime(2025, 9, 29, 10, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Bom dia!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa o final da manhã, um minuto antes do meio-dia.
    @Test
    public void deveRetornarBomDiaUmMinutoAntesDoMeioDia() {
        DateTime time = new DateTime(2025, 9, 29, 11, 59, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Bom dia!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa a transição manhã/tarde, 1 segundo antes do meio-dia.
    @Test
    public void deveRetornarBomDiaUmSegundoAntesDoMeioDia() {
        DateTime time = new DateTime(2025, 9, 29, 11, 59, 59);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Bom dia!", time), generator.generateGreetingByTimeOfDay());
    }

    // --- Testes para o Período da TARDE ---

    // Testa o início da tarde, exatamente às 12:00.
    @Test
    public void deveRetornarBoaTardeExatamenteAs12h() {
        DateTime time = new DateTime(2025, 9, 29, 12, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa tarde!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um minuto após o início da tarde.
    @Test
    public void deveRetornarBoaTardeUmMinutoAposAs12h() {
        DateTime time = new DateTime(2025, 9, 29, 12, 1, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa tarde!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um horário no meio da tarde.
    @Test
    public void deveRetornarBoaTardeAs15h() {
        DateTime time = new DateTime(2025, 9, 29, 15, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa tarde!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa o final da tarde, um minuto antes das 18:00.
    @Test
    public void deveRetornarBoaTardeUmMinutoAntesDas18h() {
        DateTime time = new DateTime(2025, 9, 29, 17, 59, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa tarde!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa a transição tarde/noite, 1 segundo antes das 18:00.
    @Test
    public void deveRetornarBoaTardeUmSegundoAntesDas18h() {
        DateTime time = new DateTime(2025, 9, 29, 17, 59, 59);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa tarde!", time), generator.generateGreetingByTimeOfDay());
    }

    // --- Testes para o Período da NOITE ---

    // Testa o início da noite, exatamente às 18:00.
    @Test
    public void deveRetornarBoaNoiteExatamenteAs18h() {
        DateTime time = new DateTime(2025, 9, 29, 18, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um minuto após o início da noite.
    @Test
    public void deveRetornarBoaNoiteUmMinutoAposAs18h() {
        DateTime time = new DateTime(2025, 9, 29, 18, 1, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um horário no meio da noite.
    @Test
    public void deveRetornarBoaNoiteAs22h() {
        DateTime time = new DateTime(2025, 9, 29, 22, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa o final do dia, um minuto antes da meia-noite.
    @Test
    public void deveRetornarBoaNoiteUmMinutoAntesDaMeiaNoite() {
        DateTime time = new DateTime(2025, 9, 29, 23, 59, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa a virada do dia, exatamente à meia-noite.
    @Test
    public void deveRetornarBoaNoiteExatamenteAMeiaNoite() {
        DateTime time = new DateTime(2025, 9, 29, 0, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um minuto após a meia-noite.
    @Test
    public void deveRetornarBoaNoiteUmMinutoAposAMeiaNoite() {
        DateTime time = new DateTime(2025, 9, 29, 0, 1, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um horário na madrugada.
    @Test
    public void deveRetornarBoaNoiteAs04hDaMadrugada() {
        DateTime time = new DateTime(2025, 9, 29, 4, 0, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa o final da noite, um minuto antes das 06:00.
    @Test
    public void deveRetornarBoaNoiteUmMinutoAntesDas06h() {
        DateTime time = new DateTime(2025, 9, 29, 5, 59, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa a transição noite/manhã, 1 segundo antes das 06:00.
    @Test
    public void deveRetornarBoaNoiteUmSegundoAntesDas06h() {
        DateTime time = new DateTime(2025, 9, 29, 5, 59, 59);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }

    // Testa um horário qualquer da noite.
    @Test
    public void deveRetornarBoaNoiteAsDezoitoETrinta() {
        DateTime time = new DateTime(2025, 9, 29, 18, 30, 0);
        when(provider.getCurrentDateTime()).thenReturn(time);
        assertEquals(formatExpected("Boa noite!", time), generator.generateGreetingByTimeOfDay());
    }
}

