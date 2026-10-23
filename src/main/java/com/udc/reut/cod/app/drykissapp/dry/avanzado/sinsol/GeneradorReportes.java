package com.udc.reut.cod.app.drykissapp.dry.avanzado.sinsol;

import java.util.List;
import java.util.Locale;

/**
 * EJERCICIO DRY AVANZADO - VERSIÓN SIN SOLUCIÓN (código que viola DRY).
 *
 * <p>Genera el reporte de una venta en tres formatos: texto, CSV y HTML.
 * Todos muestran cada producto (cantidad y valor = precio * cantidad), el
 * subtotal, el IVA (19%) y el total.</p>
 *
 * <p>PROBLEMA DRY: los tres métodos repiten el mismo "algoritmo":</p>
 * <ol>
 *   <li>validar la lista y cada producto,</li>
 *   <li>recorrer los productos calculando el valor de cada línea,</li>
 *   <li>calcular subtotal, IVA y total (la tasa 0.19 aparece 3 veces),</li>
 *   <li>formatear los números.</li>
 * </ol>
 * <p>Solo cambia la "presentación" (encabezado, línea, resumen y cierre).
 * Si el IVA cambia, o se agrega un descuento, hay que modificar los tres
 * métodos de forma idéntica. Agregar un formato JSON implicaría copiar el
 * algoritmo una cuarta vez.</p>
 *
 * <p><b>Tarea del estudiante:</b> separar el algoritmo común (cálculos y
 * recorrido) de lo que varía (formato) aplicando el patrón Template Method.</p>
 */
public class GeneradorReportes {

    public String generarTexto(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La venta no tiene productos");
        }
        StringBuilder sb = new StringBuilder("REPORTE DE VENTAS\n");
        double subtotal = 0;
        for (Producto p : productos) {
            if (p.getPrecio() < 0 || p.getCantidad() <= 0) {
                throw new IllegalArgumentException("Producto invalido: " + p.getNombre());
            }
            double valor = p.getPrecio() * p.getCantidad();
            subtotal += valor;
            sb.append(p.getNombre()).append(" x").append(p.getCantidad())
              .append(" = ").append(String.format(Locale.US, "%.2f", valor)).append("\n");
        }
        double iva = subtotal * 0.19;
        double total = subtotal + iva;
        sb.append("Subtotal: ").append(String.format(Locale.US, "%.2f", subtotal)).append("\n");
        sb.append("IVA: ").append(String.format(Locale.US, "%.2f", iva)).append("\n");
        sb.append("Total: ").append(String.format(Locale.US, "%.2f", total)).append("\n");
        return sb.toString();
    }

    // DUPLICADO: mismo algoritmo que generarTexto, solo cambia el formato
    public String generarCsv(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La venta no tiene productos");
        }
        StringBuilder sb = new StringBuilder("producto,cantidad,valor\n");
        double subtotal = 0;
        for (Producto p : productos) {
            if (p.getPrecio() < 0 || p.getCantidad() <= 0) {
                throw new IllegalArgumentException("Producto invalido: " + p.getNombre());
            }
            double valor = p.getPrecio() * p.getCantidad();
            subtotal += valor;
            sb.append(p.getNombre()).append(",").append(p.getCantidad())
              .append(",").append(String.format(Locale.US, "%.2f", valor)).append("\n");
        }
        double iva = subtotal * 0.19;
        double total = subtotal + iva;
        sb.append("subtotal,,").append(String.format(Locale.US, "%.2f", subtotal)).append("\n");
        sb.append("iva,,").append(String.format(Locale.US, "%.2f", iva)).append("\n");
        sb.append("total,,").append(String.format(Locale.US, "%.2f", total)).append("\n");
        return sb.toString();
    }

    // DUPLICADO: mismo algoritmo que generarTexto, solo cambia el formato
    public String generarHtml(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("La venta no tiene productos");
        }
        StringBuilder sb = new StringBuilder("<table>\n");
        sb.append("<tr><th>Producto</th><th>Cantidad</th><th>Valor</th></tr>\n");
        double subtotal = 0;
        for (Producto p : productos) {
            if (p.getPrecio() < 0 || p.getCantidad() <= 0) {
                throw new IllegalArgumentException("Producto invalido: " + p.getNombre());
            }
            double valor = p.getPrecio() * p.getCantidad();
            subtotal += valor;
            sb.append("<tr><td>").append(p.getNombre()).append("</td><td>")
              .append(p.getCantidad()).append("</td><td>")
              .append(String.format(Locale.US, "%.2f", valor)).append("</td></tr>\n");
        }
        double iva = subtotal * 0.19;
        double total = subtotal + iva;
        sb.append("<tr><td colspan=\"2\">Subtotal</td><td>")
          .append(String.format(Locale.US, "%.2f", subtotal)).append("</td></tr>\n");
        sb.append("<tr><td colspan=\"2\">IVA</td><td>")
          .append(String.format(Locale.US, "%.2f", iva)).append("</td></tr>\n");
        sb.append("<tr><td colspan=\"2\">Total</td><td>")
          .append(String.format(Locale.US, "%.2f", total)).append("</td></tr>\n");
        sb.append("</table>\n");
        return sb.toString();
    }
}
