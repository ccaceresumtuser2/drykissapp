package com.udc.reut.cod.app.drykissapp.dry.avanzado.consol;

import java.util.List;
import java.util.Locale;

/**
 * EJERCICIO DRY AVANZADO - VERSIÓN CON SOLUCIÓN (patrón Template Method).
 *
 * <p>{@link #generar} es el "método plantilla": contiene el algoritmo común
 * a todos los reportes (validar, recorrer, calcular totales, formatear
 * números) y se escribe UNA sola vez. Las subclases solo implementan los
 * pasos que cambian según el formato.</p>
 *
 * <p>Agregar un formato nuevo (JSON, Markdown...) = crear una subclase con
 * tres métodos cortos, sin tocar los cálculos.</p>
 */
public abstract class ReporteVenta {

    /** Método plantilla: {@code final} para que las subclases no alteren el algoritmo. */
    public final String generar(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La venta no tiene productos");
        }
        StringBuilder sb = new StringBuilder(encabezado());
        for (Producto p : productos) {
            sb.append(linea(p, formatear(p.valorLinea())));
        }
        double subtotal = CalculadoraVenta.subtotal(productos);
        sb.append(resumen("Subtotal", formatear(subtotal)));
        sb.append(resumen("IVA", formatear(CalculadoraVenta.iva(subtotal))));
        sb.append(resumen("Total", formatear(CalculadoraVenta.total(subtotal))));
        sb.append(cierre());
        return sb.toString();
    }

    /** Paso variable: primeras líneas del reporte. */
    protected abstract String encabezado();

    /** Paso variable: una línea por producto, con su valor ya formateado. */
    protected abstract String linea(Producto producto, String valor);

    /** Paso variable: una línea de resumen (Subtotal, IVA o Total). */
    protected abstract String resumen(String etiqueta, String valor);

    /** Gancho opcional: por defecto el reporte no tiene cierre. */
    protected String cierre() {
        return "";
    }

    /** Formato numérico único para todos los reportes. */
    private static String formatear(double valor) {
        return String.format(Locale.US, "%.2f", valor);
    }
}
