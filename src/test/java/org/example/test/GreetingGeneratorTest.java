package org.example.test;

import org.example.DateTimeProvider;
import org.example.GreetingGenerator;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GreetingGeneratorTest {

    // 5 Casos de Teste POSITIVOS

    @Test
    public void deveRetornarBomDiaParaHorarioMatutino() {

        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(2025, 9, 1, 9, 0, 0));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        String result = generator.generateGreetingByTimeOfDay();

        assertTrue(result.startsWith("Bom dia!"));
        assertTrue(result.contains("01/09/2025 09:00:00"));
    }

    @Test
    public void deveRetornarBoaTardeParaHorarioVespertino() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(2025, 9, 1, 14, 30, 0));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        String result = generator.generateGreetingByTimeOfDay();

        assertTrue(result.startsWith("Boa tarde!"));
    }

    @Test
    public void deveRetornarBoaNoiteParaHorarioNoturno() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(2025, 9, 1, 22, 0, 0));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        String result = generator.generateGreetingByTimeOfDay();

        assertTrue(result.startsWith("Boa noite!"));
    }

    @Test
    public void deveRetornarBoaTardeExatamenteAoMeioDia() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(2025, 9, 1, 12, 0, 0));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        String result = generator.generateGreetingByTimeOfDay();

        assertTrue(result.startsWith("Boa tarde!"));
    }

    @Test
    public void deveRetornarBomDiaUmSegundoAntesDoMeioDia() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(2025, 9, 1, 11, 59, 59));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        String result = generator.generateGreetingByTimeOfDay();

        assertTrue(result.startsWith("Bom dia!"));
    }

    // 5 Casos de Teste NEGATIVOS

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeOProvedorForNuloNoConstrutor() {
        new GreetingGenerator(null);
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoSeProvedorRetornarDataNula() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(null);
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        generator.generateGreetingByTimeOfDay();
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParaDatasAnterioresA1970() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(1969, 12, 31, 23, 59, 59));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        generator.generateGreetingByTimeOfDay();
    }

    @Test
    public void deveTerMensagemDeErroCorretaParaProvedorNulo() {
        try {
            new GreetingGenerator(null);
        } catch (IllegalArgumentException e) {
            assertEquals("O provedor de data não pode ser nulo.", e.getMessage());
        }
    }

    @Test
    public void deveTerMensagemDeErroCorretaParaDataAnteriorA1970() {
        DateTimeProvider mockProvider = mock(DateTimeProvider.class);
        when(mockProvider.getCurrentDateTime()).thenReturn(new DateTime(1960, 1, 1, 0, 0, 0));
        GreetingGenerator generator = new GreetingGenerator(mockProvider);

        try {
            generator.generateGreetingByTimeOfDay();
        } catch (IllegalArgumentException e) {
            assertEquals("Datas anteriores a 1970 não são suportadas.", e.getMessage());
        }
    }
}