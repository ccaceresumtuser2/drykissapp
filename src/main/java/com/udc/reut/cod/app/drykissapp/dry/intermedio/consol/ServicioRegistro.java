package com.udc.reut.cod.app.drykissapp.dry.intermedio.consol;

import java.util.ArrayList;
import java.util.List;

/**
 * EJERCICIO DRY INTERMEDIO - VERSIÓN CON SOLUCIÓN.
 *
 * <p>La validación vive en las entidades ({@link Persona} y {@link Validador});
 * el servicio solo se ocupa de lo que le corresponde: evitar correos
 * duplicados y guardar. Una sola lista de {@link Persona} reemplaza las dos
 * listas y los dos ciclos de búsqueda.</p>
 */
public class ServicioRegistro {

    private final List<Persona> personas = new ArrayList<>();

    public Estudiante registrarEstudiante(String nombre, String correo, String codigo) {
        return registrar(new Estudiante(nombre, correo, codigo));
    }

    public Docente registrarDocente(String nombre, String correo, String departamento) {
        return registrar(new Docente(nombre, correo, departamento));
    }

    /** Lógica común de registro, escrita una sola vez para cualquier tipo de persona. */
    private <T extends Persona> T registrar(T persona) {
        if (existeCorreo(persona.getCorreo())) {
            throw new IllegalArgumentException("correo ya registrado: " + persona.getCorreo());
        }
        personas.add(persona);
        return persona;
    }

    public boolean existeCorreo(String correo) {
        String buscado = correo.trim().toLowerCase();
        return personas.stream().anyMatch(p -> p.getCorreo().equals(buscado));
    }

    public int totalRegistrados() {
        return personas.size();
    }
}
