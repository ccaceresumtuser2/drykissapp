package com.udc.reut.cod.app.drykissapp.dry.avanzado.sinsol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Pruebas de los tres formatos. La salida esperada es exactamente la misma
 * que en la versión con solución: el Template Method no cambia el resultado.
 */
class GeneradorReportesTest {

    private final GeneradorReportes generador = new GeneradorReportes();

    // Lapiz: 1000 * 2 = 2000; Cuaderno: 5000 * 1 = 5000
    // Subtotal = 7000; IVA = 7000 * 0.19 = 1330; Total = 8330
    private final List<Producto> venta = List.of(
            new Producto("Lapiz", 1000, 2),
            new Producto("Cuaderno", 5000, 1));

    @Test
    void generaReporteTexto() {
        String esperado = """
                REPORTE DE VENTAS
                Lapiz x2 = 2000.00
                Cuaderno x1 = 5000.00
                Subtotal: 7000.00
                IVA: 1330.00
                Total: 8330.00
                """;
        assertEquals(esperado, generador.generarTexto(venta));
    }

    @Test
    void generaReporteCsv() {
        String esperado = """
                producto,cantidad,valor
                Lapiz,2,2000.00
                Cuaderno,1,5000.00
                subtotal,,7000.00
                iva,,1330.00
                total,,8330.00
                """;
        assertEquals(esperado, generador.generarCsv(venta));
    }

    @Test
    void generaReporteHtml() {
        String esperado = """
                <table>
                <tr><th>Producto</th><th>Cantidad</th><th>Valor</th></tr>
                <tr><td>Lapiz</td><td>2</td><td>2000.00</td></tr>
                <tr><td>Cuaderno</td><td>1</td><td>5000.00</td></tr>
                <tr><td colspan="2">Subtotal</td><td>7000.00</td></tr>
                <tr><td colspan="2">IVA</td><td>1330.00</td></tr>
                <tr><td colspan="2">Total</td><td>8330.00</td></tr>
                </table>
                """;
        assertEquals(esperado, generador.generarHtml(venta));
    }

    @Test
    void rechazaVentaVacia() {
        assertThrows(IllegalArgumentException.class, () -> generador.generarTexto(List.of()));
        assertThrows(IllegalArgumentException.class, () -> generador.generarCsv(null));
    }

    @Test
    void rechazaProductoInvalido() {
        // En esta versión el error se detecta tarde: al generar el reporte
        List<Producto> invalida = List.of(new Producto("Borrador", -500, 1));
        assertThrows(IllegalArgumentException.class, () -> generador.generarHtml(invalida));
    }
}
