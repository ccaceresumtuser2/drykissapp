package com.udc.reut.cod.app.drykissapp.dry.avanzado.consol;

/**
 * Producto vendido.
 *
 * <p>DRY: la validación y el cálculo del valor de la línea están en un único
 * lugar, el propio producto, en vez de copiarse en cada formato de reporte.</p>
 */
public record Producto(String nombre, double precio, int cantidad) {

    public Producto {
        if (precio < 0 || cantidad <= 0) {
            throw new IllegalArgumentException("Producto invalido: " + nombre);
        }
    }

    /** Valor de la línea: precio unitario * cantidad. */
    public double valorLinea() {
        return precio * cantidad;
    }
}
