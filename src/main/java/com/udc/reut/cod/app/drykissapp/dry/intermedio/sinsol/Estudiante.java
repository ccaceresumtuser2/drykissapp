package com.udc.reut.cod.app.drykissapp.dry.intermedio.sinsol;

/**
 * Estudiante registrado.
 *
 * <p>PROBLEMA DRY: los atributos {@code nombre} y {@code correo} y sus
 * getters están copiados también en {@link Docente}.</p>
 */
public class Estudiante {

    private final String nombre;
    private final String correo;
    private final String codigo;

    public Estudiante(String nombre, String correo, String codigo) {
        this.nombre = nombre;
        this.correo = correo;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCodigo() {
        return codigo;
    }
}
