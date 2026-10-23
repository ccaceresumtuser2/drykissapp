package com.udc.reut.cod.app.drykissapp.kiss.basico.consol;

/**
 * EJERCICIO KISS BÁSICO - VERSIÓN CON SOLUCIÓN.
 *
 * <p>Mismo comportamiento que {@code kiss.basico.sinsol.UtilidadesNumero},
 * pero cada método se resuelve en una sola expresión clara usando las
 * herramientas que ya ofrece el lenguaje.</p>
 */
public class UtilidadesNumero {

    /** Nombres de los días; el índice 0 corresponde al día 1 (Lunes). */
    private static final String[] DIAS = {
        "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
    };

    /**
     * Indica si un número es par.
     * KISS: el operador módulo resuelve el problema en O(1) y en una línea.
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    /**
     * Retorna el nombre del día de la semana (1 = Lunes ... 7 = Domingo).
     * KISS: una validación de rango + un acceso al arreglo reemplazan
     * los siete if anidados.
     */
    public String nombreDia(int dia) {
        if (dia < 1 || dia > 7) {
            return "Invalido";
        }
        return DIAS[dia - 1];
    }

    /**
     * Retorna el mayor de tres números.
     * KISS: reutilizar {@link Math#max(int, int)} en lugar de reinventarlo.
     */
    public int mayor(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
