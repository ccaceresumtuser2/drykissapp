package com.udc.reut.cod.app.drykissapp.dry.avanzado.consol;

/** Reporte en texto plano: solo define cómo se ve cada parte. */
public class ReporteTexto extends ReporteVenta {

    @Override
    protected String encabezado() {
        return "REPORTE DE VENTAS\n";
    }

    @Override
    protected String linea(Producto producto, String valor) {
        return producto.nombre() + " x" + producto.cantidad() + " = " + valor + "\n";
    }

    @Override
    protected String resumen(String etiqueta, String valor) {
        return etiqueta + ": " + valor + "\n";
    }
}
