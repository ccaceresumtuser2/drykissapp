package com.udc.reut.cod.app.drykissapp.dry.avanzado.consol;

/** Reporte CSV: solo define cómo se ve cada parte. */
public class ReporteCsv extends ReporteVenta {

    @Override
    protected String encabezado() {
        return "producto,cantidad,valor\n";
    }

    @Override
    protected String linea(Producto producto, String valor) {
        return producto.nombre() + "," + producto.cantidad() + "," + valor + "\n";
    }

    @Override
    protected String resumen(String etiqueta, String valor) {
        return etiqueta.toLowerCase() + ",," + valor + "\n";
    }
}
