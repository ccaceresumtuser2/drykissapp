package com.udc.reut.cod.app.drykissapp.dry.intermedio.consol;

/** Estudiante: solo declara lo que lo diferencia de una {@link Persona}. */
public class Estudiante extends Persona {

    private final String codigo;

    public Estudiante(String nombre, String correo, String codigo) {
        super(nombre, correo);
        this.codigo = Validador.obligatorio(codigo, "codigo");
    }

    public String getCodigo() {
        return codigo;
    }
}
