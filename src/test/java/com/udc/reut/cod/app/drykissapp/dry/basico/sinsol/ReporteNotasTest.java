package com.udc.reut.cod.app.drykissapp.dry.basico.sinsol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Pruebas de la versión duplicada. Observe que las pruebas TAMBIÉN se
 * duplican: hay que probar el mismo algoritmo tres veces porque hay tres
 * copias que pueden divergir.
 */
class ReporteNotasTest {

    private final ReporteNotas reporte = new ReporteNotas();
    private final double[] notasAprobadas = {3.0, 4.0, 5.0};
    private final double[] notasReprobadas = {2.0, 3.0, 2.5};

    @Test
    void promediosDeLasTresMaterias() {
        assertEquals(4.0, reporte.promedioMatematicas(notasAprobadas), 0.001);
        assertEquals(4.0, reporte.promedioFisica(notasAprobadas), 0.001);
        assertEquals(4.0, reporte.promedioProgramacion(notasAprobadas), 0.001);
    }

    @Test
    void estadosDeLasTresMaterias() {
        assertEquals("APROBADO", reporte.estadoMatematicas(notasAprobadas));
        assertEquals("REPROBADO", reporte.estadoFisica(notasReprobadas));
        assertEquals("APROBADO", reporte.estadoProgramacion(new double[] {3.0}));
    }

    @Test
    void validacionesEnLasTresMaterias() {
        assertThrows(IllegalArgumentException.class, () -> reporte.promedioMatematicas(new double[] {}));
        assertThrows(IllegalArgumentException.class, () -> reporte.promedioFisica(new double[] {5.1}));
        assertThrows(IllegalArgumentException.class, () -> reporte.promedioProgramacion(null));
    }
}
