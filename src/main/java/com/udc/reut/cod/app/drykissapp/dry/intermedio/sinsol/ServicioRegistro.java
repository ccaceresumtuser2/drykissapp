package com.udc.reut.cod.app.drykissapp.dry.intermedio.sinsol;

import java.util.ArrayList;
import java.util.List;

/**
 * EJERCICIO DRY INTERMEDIO - VERSIÓN SIN SOLUCIÓN (código que viola DRY).
 *
 * <p>Registra estudiantes y docentes con estas reglas:</p>
 * <ul>
 *   <li>Nombre obligatorio (se guarda sin espacios al inicio/fin).</li>
 *   <li>Correo con formato usuario@dominio.ext (se guarda en minúsculas).</li>
 *   <li>Código (estudiante) y departamento (docente) obligatorios.</li>
 *   <li>No se permiten dos personas con el mismo correo.</li>
 * </ul>
 *
 * <p>PROBLEMA DRY: {@link #registrarEstudiante} y {@link #registrarDocente}
 * repiten la validación de nombre, la validación del correo, la
 * normalización y la verificación de duplicados. La expresión regular del
 * correo está copiada dos veces: si se corrige en un método y no en el otro,
 * estudiantes y docentes tendrán reglas distintas sin que nadie lo note.</p>
 *
 * <p><b>Tarea del estudiante:</b> extraer lo común a una superclase
 * {@code Persona} y a un {@code Validador} reutilizable.</p>
 */
public class ServicioRegistro {

    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final List<Docente> docentes = new ArrayList<>();

    public Estudiante registrarEstudiante(String nombre, String correo, String codigo) {
        // --- inicio bloque duplicado ---
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre es obligatorio");
        }
        if (correo == null || !correo.trim().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("correo invalido: " + correo);
        }
        String nombreLimpio = nombre.trim();
        String correoLimpio = correo.trim().toLowerCase();
        if (existeCorreo(correoLimpio)) {
            throw new IllegalArgumentException("correo ya registrado: " + correoLimpio);
        }
        // --- fin bloque duplicado ---
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("codigo es obligatorio");
        }
        Estudiante estudiante = new Estudiante(nombreLimpio, correoLimpio, codigo.trim());
        estudiantes.add(estudiante);
        return estudiante;
    }

    public Docente registrarDocente(String nombre, String correo, String departamento) {
        // --- inicio bloque duplicado (copiado de registrarEstudiante) ---
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre es obligatorio");
        }
        if (correo == null || !correo.trim().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("correo invalido: " + correo);
        }
        String nombreLimpio = nombre.trim();
        String correoLimpio = correo.trim().toLowerCase();
        if (existeCorreo(correoLimpio)) {
            throw new IllegalArgumentException("correo ya registrado: " + correoLimpio);
        }
        // --- fin bloque duplicado ---
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException("departamento es obligatorio");
        }
        Docente docente = new Docente(nombreLimpio, correoLimpio, departamento.trim());
        docentes.add(docente);
        return docente;
    }

    /** PROBLEMA DRY: el mismo ciclo de búsqueda se escribe una vez por lista. */
    public boolean existeCorreo(String correo) {
        String buscado = correo.trim().toLowerCase();
        for (Estudiante e : estudiantes) {
            if (e.getCorreo().equals(buscado)) {
                return true;
            }
        }
        for (Docente d : docentes) {
            if (d.getCorreo().equals(buscado)) {
                return true;
            }
        }
        return false;
    }

    public int totalRegistrados() {
        return estudiantes.size() + docentes.size();
    }
}
