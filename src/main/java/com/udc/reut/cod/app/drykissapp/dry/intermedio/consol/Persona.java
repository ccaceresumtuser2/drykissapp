package com.udc.reut.cod.app.drykissapp.dry.intermedio.consol;

/**
 * Superclase con los datos comunes a todas las personas registradas.
 *
 * <p>DRY: {@code nombre}, {@code correo}, sus getters y su validación se
 * definen una vez. Al validar en el constructor es imposible crear una
 * persona inválida, sin importar quién la construya.</p>
 */
public abstract class Persona {

    private final String nombre;
    private final String correo;

    protected Persona(String nombre, String correo) {
        this.nombre = Validador.obligatorio(nombre, "nombre");
        this.correo = Validador.correo(correo);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
