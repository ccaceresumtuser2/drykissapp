package com.udc.reut.cod.app.drykissapp.dry.avanzado.consol;

/** Reporte HTML (tabla): solo define cómo se ve cada parte. */
public class ReporteHtml extends ReporteVenta {

    @Override
    protected String encabezado() {
        return "<table>\n<tr><th>Producto</th><th>Cantidad</th><th>Valor</th></tr>\n";
    }

    @Override
    protected String linea(Producto producto, String valor) {
        return "<tr><td>" + producto.nombre() + "</td><td>" + producto.cantidad()
                + "</td><td>" + valor + "</td></tr>\n";
    }

    @Override
    protected String resumen(String etiqueta, String valor) {
        return "<tr><td colspan=\"2\">" + etiqueta + "</td><td>" + valor + "</td></tr>\n";
    }

    @Override
    protected String cierre() {
        return "</table>\n";
    }
}
