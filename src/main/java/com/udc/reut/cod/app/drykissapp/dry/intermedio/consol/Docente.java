package com.udc.reut.cod.app.drykissapp.dry.intermedio.consol;

/** Docente: solo declara lo que lo diferencia de una {@link Persona}. */
public class Docente extends Persona {

    private final String departamento;

    public Docente(String nombre, String correo, String departamento) {
        super(nombre, correo);
        this.departamento = Validador.obligatorio(departamento, "departamento");
    }

    public String getDepartamento() {
        return departamento;
    }
}
