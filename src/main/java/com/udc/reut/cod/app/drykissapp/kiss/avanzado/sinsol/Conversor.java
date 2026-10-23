package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/**
 * EJERCICIO KISS AVANZADO - VERSIÓN SIN SOLUCIÓN (sobre-ingeniería).
 *
 * <p>Interfaz "por si algún día" hay más conversiones. Hoy solo existen dos
 * fórmulas, pero para usarlas hay que atravesar 8 tipos: interfaz, clase
 * abstracta, dos implementaciones, fábrica, singleton, contexto y fachada.</p>
 *
 * <p>PROBLEMA KISS/YAGNI: abstracciones creadas para requisitos que no
 * existen.</p>
 */
public interface Conversor {

    /** Convierte un valor de temperatura. */
    double convertir(double valor);

    /** Código con el que la fábrica registra el conversor (ej. "C_A_F"). */
    String getCodigo();
}
