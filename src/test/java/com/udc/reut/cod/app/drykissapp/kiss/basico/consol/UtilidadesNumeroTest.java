package com.udc.reut.cod.app.drykissapp.kiss.basico.consol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Pruebas de la versión CON solución: son las mismas que las de la versión
 * sin solución, lo que demuestra que la simplificación no cambió el
 * comportamiento.
 */
class UtilidadesNumeroTest {

    private final UtilidadesNumero utilidades = new UtilidadesNumero();

    @Test
    void esParReconocePares() {
        assertTrue(utilidades.esPar(0));
        assertTrue(utilidades.esPar(10));
        assertTrue(utilidades.esPar(-4));
    }

    @Test
    void esParReconoceImpares() {
        assertFalse(utilidades.esPar(7));
        assertFalse(utilidades.esPar(-3));
    }

    @Test
    void esParFuncionaConNumerosGrandes() {
        // La versión sin solución tardaría segundos en este caso (ciclo O(n))
        assertFalse(utilidades.esPar(Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @CsvSource({"1,Lunes", "3,Miercoles", "7,Domingo", "0,Invalido", "8,Invalido"})
    void nombreDiaRetornaNombreCorrecto(int dia, String esperado) {
        assertEquals(esperado, utilidades.nombreDia(dia));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,3", "9,2,3,9", "1,8,3,8", "5,5,5,5", "-1,-2,-3,-1"})
    void mayorRetornaElMayorDeTres(int a, int b, int c, int esperado) {
        assertEquals(esperado, utilidades.mayor(a, b, c));
    }
}
