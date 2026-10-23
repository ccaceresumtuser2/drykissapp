package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/**
 * Clase abstracta con un "Template Method" y ganchos (hooks) que ninguna
 * subclase usa.
 *
 * <p>PROBLEMA KISS: se agrega una capa de herencia para una fórmula de una
 * línea. Los métodos {@link #preProcesar} y {@link #postProcesar} existen
 * "por si acaso" y solo devuelven el mismo valor.</p>
 */
public abstract class ConversorAbstracto implements Conversor {

    @Override
    public final double convertir(double valor) {
        validar(valor);
        double entrada = preProcesar(valor);
        double resultado = hacerConversion(entrada);
        return postProcesar(resultado);
    }

    /** Validación genérica: hoy solo rechaza NaN. */
    protected void validar(double valor) {
        if (Double.isNaN(valor)) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    /** Gancho vacío: nadie lo sobrescribe. */
    protected double preProcesar(double valor) {
        return valor;
    }

    /** Gancho vacío: nadie lo sobrescribe. */
    protected double postProcesar(double valor) {
        return valor;
    }

    /** La única parte que realmente importa: la fórmula. */
    protected abstract double hacerConversion(double valor);
}
