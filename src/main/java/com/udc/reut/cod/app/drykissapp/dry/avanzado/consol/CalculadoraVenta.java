package com.udc.reut.cod.app.drykissapp.dry.avanzado.consol;

import java.util.List;

/**
 * Reglas de cálculo de una venta.
 *
 * <p>DRY: la tasa de IVA y las fórmulas de subtotal/IVA/total se definen una
 * sola vez. Cambiar el IVA o agregar un descuento se hace aquí y todos los
 * formatos de reporte lo reflejan automáticamente.</p>
 */
public final class CalculadoraVenta {

    public static final double TASA_IVA = 0.19;

    private CalculadoraVenta() {
    }

    public static double subtotal(List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::valorLinea).sum();
    }

    public static double iva(double subtotal) {
        return subtotal * TASA_IVA;
    }

    public static double total(double subtotal) {
        return subtotal + iva(subtotal);
    }
}
