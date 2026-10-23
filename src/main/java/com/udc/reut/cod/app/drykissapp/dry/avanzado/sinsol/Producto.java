package com.udc.reut.cod.app.drykissapp.dry.avanzado.sinsol;

/**
 * Producto vendido: nombre, precio unitario y cantidad.
 *
 * <p>No valida sus datos: cada método de {@link GeneradorReportes} tiene su
 * propia copia de la validación.</p>
 */
public class Producto {

    private final String nombre;
    private final double precio;
    private final int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
