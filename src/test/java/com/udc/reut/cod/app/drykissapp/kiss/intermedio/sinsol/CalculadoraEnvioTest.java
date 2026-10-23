package com.udc.reut.cod.app.drykissapp.kiss.intermedio.sinsol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Pruebas de las reglas de negocio del envío. Son idénticas para la versión
 * sin solución y con solución: la refactorización no debe cambiar resultados.
 */
class CalculadoraEnvioTest {

    private final CalculadoraEnvio calculadora = new CalculadoraEnvio();

    @ParameterizedTest(name = "{0} kg a {1}, premium={2} -> {3}")
    @CsvSource({
        "5,  NACIONAL,      false, 5000",
        "10, NACIONAL,      false, 5000",   // límite: 10 kg aún no tiene recargo
        "12, NACIONAL,      false, 7000",   // 2 kg extra * 1000
        "12, NACIONAL,      true,  3500",   // premium paga la mitad
        "1,  INTERNACIONAL, false, 20000",
        "15, internacional, true,  12500",  // (20000 + 5000) / 2, sin importar mayúsculas
    })
    void calculaCostoSegunReglas(int peso, String destino, boolean premium, double esperado) {
        assertEquals(esperado, calculadora.calcularCosto(peso, destino, premium), 0.001);
    }

    @Test
    void rechazaPesoNoPositivo() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularCosto(0, "NACIONAL", false));
    }

    @Test
    void rechazaDestinoNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularCosto(5, null, false));
    }

    @Test
    void rechazaDestinoDesconocido() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularCosto(5, "LUNA", false));
    }
}
