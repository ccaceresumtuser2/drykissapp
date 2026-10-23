package com.udc.reut.cod.app.drykissapp.dry.intermedio.consol;

import java.util.regex.Pattern;

/**
 * Única fuente de verdad para las reglas de validación de texto.
 *
 * <p>DRY: la expresión regular del correo y la regla de "campo obligatorio"
 * se escriben una sola vez y se reutilizan para nombre, código y
 * departamento.</p>
 */
public final class Validador {

    private static final Pattern FORMATO_CORREO =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private Validador() {
    }

    /** Valida que el valor no sea nulo ni vacío y lo retorna sin espacios extremos. */
    public static String obligatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return valor.trim();
    }

    /** Valida el formato del correo y lo retorna normalizado (minúsculas). */
    public static String correo(String correo) {
        if (correo == null || !FORMATO_CORREO.matcher(correo.trim()).matches()) {
            throw new IllegalArgumentException("correo invalido: " + correo);
        }
        return correo.trim().toLowerCase();
    }
}
