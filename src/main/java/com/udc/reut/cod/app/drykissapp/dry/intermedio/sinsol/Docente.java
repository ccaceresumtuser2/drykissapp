package com.udc.reut.cod.app.drykissapp.dry.intermedio.sinsol;

/**
 * Docente registrado.
 *
 * <p>PROBLEMA DRY: {@code nombre}, {@code correo} y sus getters son una copia
 * de los de {@link Estudiante}.</p>
 */
public class Docente {

    private final String nombre;
    private final String correo;
    private final String departamento;

    public Docente(String nombre, String correo, String departamento) {
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDepartamento() {
        return departamento;
    }
}
