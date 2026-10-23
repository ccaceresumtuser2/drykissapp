package com.udc.reut.cod.app.drykissapp.dry.basico.sinsol;

/**
 * EJERCICIO DRY BÁSICO - VERSIÓN SIN SOLUCIÓN (código que viola DRY).
 *
 * <p>Calcula el promedio y el estado (APROBADO/REPROBADO) de tres materias.
 * Escala de notas de 0.0 a 5.0; se aprueba con 3.0 o más.</p>
 *
 * <p>PROBLEMA DRY: los tres métodos de promedio son idénticos excepto por el
 * nombre; lo mismo ocurre con los tres métodos de estado. La nota mínima
 * (3.0) y el rango (0 a 5) están copiados en varios lugares. Si la
 * universidad cambia la nota mínima a 3.5 hay que editar 3 sitios... y es
 * fácil olvidar uno.</p>
 *
 * <p><b>Tarea del estudiante:</b> dejar una sola implementación de cada
 * regla (promedio, validación, estado) y una sola constante por valor.</p>
 */
public class ReporteNotas {

    public double promedioMatematicas(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("No hay notas");
        }
        double suma = 0;
        for (double nota : notas) {
            if (nota < 0 || nota > 5) {
                throw new IllegalArgumentException("Nota fuera de rango: " + nota);
            }
            suma += nota;
        }
        return suma / notas.length;
    }

    // DUPLICADO: copia exacta de promedioMatematicas
    public double promedioFisica(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("No hay notas");
        }
        double suma = 0;
        for (double nota : notas) {
            if (nota < 0 || nota > 5) {
                throw new IllegalArgumentException("Nota fuera de rango: " + nota);
            }
            suma += nota;
        }
        return suma / notas.length;
    }

    // DUPLICADO: copia exacta de promedioMatematicas
    public double promedioProgramacion(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("No hay notas");
        }
        double suma = 0;
        for (double nota : notas) {
            if (nota < 0 || nota > 5) {
                throw new IllegalArgumentException("Nota fuera de rango: " + nota);
            }
            suma += nota;
        }
        return suma / notas.length;
    }

    // DUPLICADO: la regla "3.0 aprueba" aparece en los tres métodos de estado
    public String estadoMatematicas(double[] notas) {
        if (promedioMatematicas(notas) >= 3.0) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }

    public String estadoFisica(double[] notas) {
        if (promedioFisica(notas) >= 3.0) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }

    public String estadoProgramacion(double[] notas) {
        if (promedioProgramacion(notas) >= 3.0) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }
}
