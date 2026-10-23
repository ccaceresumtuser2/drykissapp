package com.udc.reut.cod.app.drykissapp.dry.basico.consol;

/**
 * EJERCICIO DRY BÁSICO - VERSIÓN CON SOLUCIÓN.
 *
 * <p>Cada regla del negocio vive en un único lugar:</p>
 * <ul>
 *   <li>Rango y nota mínima: constantes.</li>
 *   <li>Validación + promedio: un solo método {@link #promedio}.</li>
 *   <li>Estado: un solo método {@link #estado} que reutiliza el promedio.</li>
 * </ul>
 * <p>La materia ya no es parte del nombre del método: es un dato que decide
 * quien llama. Agregar "Química" no requiere tocar esta clase.</p>
 */
public class ReporteNotas {

    public static final double NOTA_MINIMA = 0.0;
    public static final double NOTA_MAXIMA = 5.0;
    public static final double NOTA_APROBATORIA = 3.0;

    /** Promedio de las notas de cualquier materia. */
    public double promedio(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("No hay notas");
        }
        double suma = 0;
        for (double nota : notas) {
            validarRango(nota);
            suma += nota;
        }
        return suma / notas.length;
    }

    /** APROBADO o REPROBADO según el promedio de cualquier materia. */
    public String estado(double[] notas) {
        return promedio(notas) >= NOTA_APROBATORIA ? "APROBADO" : "REPROBADO";
    }

    private void validarRango(double nota) {
        if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {
            throw new IllegalArgumentException("Nota fuera de rango: " + nota);
        }
    }
}
