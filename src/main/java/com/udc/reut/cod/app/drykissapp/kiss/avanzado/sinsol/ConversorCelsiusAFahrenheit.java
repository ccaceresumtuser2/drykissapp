package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/** Implementación concreta: toda una clase para la fórmula F = C * 9/5 + 32. */
public class ConversorCelsiusAFahrenheit extends ConversorAbstracto {

    @Override
    protected double hacerConversion(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    @Override
    public String getCodigo() {
        return "C_A_F";
    }
}
