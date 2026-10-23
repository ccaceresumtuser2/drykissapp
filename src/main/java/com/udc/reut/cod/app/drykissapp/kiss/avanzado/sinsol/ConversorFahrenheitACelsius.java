package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/** Implementación concreta: toda una clase para la fórmula C = (F - 32) * 5/9. */
public class ConversorFahrenheitACelsius extends ConversorAbstracto {

    @Override
    protected double hacerConversion(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    @Override
    public String getCodigo() {
        return "F_A_C";
    }
}
