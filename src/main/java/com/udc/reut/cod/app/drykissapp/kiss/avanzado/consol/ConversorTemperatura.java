package com.udc.reut.cod.app.drykissapp.kiss.avanzado.consol;

/**
 * EJERCICIO KISS AVANZADO - VERSIÓN CON SOLUCIÓN.
 *
 * <p>Los 8 tipos de la versión sin solución se reemplazan por una clase
 * utilitaria con dos métodos estáticos:</p>
 * <ul>
 *   <li>Los nombres de los métodos documentan la conversión (no hay códigos
 *       de texto "mágicos" ni errores en tiempo de ejecución por tipeo).</li>
 *   <li>Sin Singleton, sin fábrica, sin estado: fácil de probar.</li>
 *   <li>Si mañana aparece Kelvin, se agrega un método. Los patrones se
 *       introducen cuando un requisito real los justifica (YAGNI).</li>
 * </ul>
 */
public final class ConversorTemperatura {

    /** Clase utilitaria: no se instancia. */
    private ConversorTemperatura() {
    }

    /** F = C * 9/5 + 32 */
    public static double celsiusAFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    /** C = (F - 32) * 5/9 */
    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
