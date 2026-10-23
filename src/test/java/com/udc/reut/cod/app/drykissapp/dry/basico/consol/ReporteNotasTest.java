package com.udc.reut.cod.app.drykissapp.dry.basico.consol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Pruebas de la versión DRY: como solo hay una implementación, basta con
 * probarla una vez para cubrir todas las materias.
 */
class ReporteNotasTest {

    private final ReporteNotas reporte = new ReporteNotas();

    @Test
    void calculaPromedio() {
        assertEquals(4.0, reporte.promedio(new double[] {3.0, 4.0, 5.0}), 0.001);
    }

    @Test
    void estadoAprobadoDesdeLaNotaMinima() {
        assertEquals("APROBADO", reporte.estado(new double[] {3.0}));
        assertEquals("APROBADO", reporte.estado(new double[] {3.0, 4.0, 5.0}));
    }

    @Test
    void estadoReprobado() {
        assertEquals("REPROBADO", reporte.estado(new double[] {2.0, 3.0, 2.5}));
    }

    @Test
    void rechazaListaVaciaONula() {
        assertThrows(IllegalArgumentException.class, () -> reporte.promedio(new double[] {}));
        assertThrows(IllegalArgumentException.class, () -> reporte.promedio(null));
    }

    @Test
    void rechazaNotasFueraDeRango() {
        assertThrows(IllegalArgumentException.class, () -> reporte.promedio(new double[] {5.1}));
        assertThrows(IllegalArgumentException.class, () -> reporte.promedio(new double[] {-0.1}));
    }
}
