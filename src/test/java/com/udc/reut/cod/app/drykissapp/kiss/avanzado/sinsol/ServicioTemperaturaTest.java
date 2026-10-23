package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Pruebas de la versión sobre-diseñada. Nótese que el cliente debe conocer
 * los códigos "C_A_F" y "F_A_C", y que existe una prueba extra solo para
 * cubrir un error (código inválido) que la versión simple hace imposible.
 */
class ServicioTemperaturaTest {

    private final ServicioTemperatura servicio = new ServicioTemperatura();

    @ParameterizedTest
    @CsvSource({"0,32", "100,212", "-40,-40", "37,98.6"})
    void convierteCelsiusAFahrenheit(double celsius, double fahrenheit) {
        assertEquals(fahrenheit, servicio.convertir(celsius, "C_A_F"), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"32,0", "212,100", "-40,-40", "98.6,37"})
    void convierteFahrenheitACelsius(double fahrenheit, double celsius) {
        assertEquals(celsius, servicio.convertir(fahrenheit, "F_A_C"), 0.001);
    }

    @Test
    void codigoDesconocidoFallaEnTiempoDeEjecucion() {
        // Un simple error de tipeo ("C_a_F") compila sin problemas y falla al ejecutar
        assertThrows(IllegalArgumentException.class, () -> servicio.convertir(10, "C_a_F"));
    }
}
