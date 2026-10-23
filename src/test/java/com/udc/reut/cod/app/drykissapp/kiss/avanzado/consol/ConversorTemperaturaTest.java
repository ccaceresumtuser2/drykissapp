package com.udc.reut.cod.app.drykissapp.kiss.avanzado.consol;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Mismos casos de conversión que la versión sin solución. La prueba de
 * "código desconocido" desaparece: con métodos de nombre explícito ese
 * error ya no puede ocurrir (el compilador lo detecta).
 */
class ConversorTemperaturaTest {

    @ParameterizedTest
    @CsvSource({"0,32", "100,212", "-40,-40", "37,98.6"})
    void convierteCelsiusAFahrenheit(double celsius, double fahrenheit) {
        assertEquals(fahrenheit, ConversorTemperatura.celsiusAFahrenheit(celsius), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"32,0", "212,100", "-40,-40", "98.6,37"})
    void convierteFahrenheitACelsius(double fahrenheit, double celsius) {
        assertEquals(celsius, ConversorTemperatura.fahrenheitACelsius(fahrenheit), 0.001);
    }
}
