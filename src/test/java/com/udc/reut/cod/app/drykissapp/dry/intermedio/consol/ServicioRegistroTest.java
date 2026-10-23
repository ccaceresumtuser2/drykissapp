package com.udc.reut.cod.app.drykissapp.dry.intermedio.consol;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Pruebas del registro. Son idénticas para la versión sin solución y con
 * solución: la eliminación de duplicados no debe cambiar el comportamiento.
 */
class ServicioRegistroTest {

    private final ServicioRegistro servicio = new ServicioRegistro();

    @Test
    void registraEstudianteNormalizandoDatos() {
        Estudiante e = servicio.registrarEstudiante("  Ana Ruiz ", " ANA@UDC.EDU.CO ", "2024001");
        assertEquals("Ana Ruiz", e.getNombre());
        assertEquals("ana@udc.edu.co", e.getCorreo());
        assertEquals("2024001", e.getCodigo());
    }

    @Test
    void registraDocenteNormalizandoDatos() {
        Docente d = servicio.registrarDocente("Luis Paz", "Luis@udc.edu.co", " Sistemas ");
        assertEquals("luis@udc.edu.co", d.getCorreo());
        assertEquals("Sistemas", d.getDepartamento());
    }

    @Test
    void cuentaTodosLosRegistrados() {
        servicio.registrarEstudiante("Ana", "ana@udc.edu.co", "1");
        servicio.registrarDocente("Luis", "luis@udc.edu.co", "Sistemas");
        assertEquals(2, servicio.totalRegistrados());
        assertTrue(servicio.existeCorreo("LUIS@udc.edu.co"));
    }

    @Test
    void rechazaNombreVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarEstudiante("  ", "ana@udc.edu.co", "1"));
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarDocente(null, "luis@udc.edu.co", "Sistemas"));
    }

    @Test
    void rechazaCorreoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarEstudiante("Ana", "ana.udc.edu.co", "1"));
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarDocente("Luis", "luis@udc", "Sistemas"));
    }

    @Test
    void rechazaCamposPropiosVacios() {
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarEstudiante("Ana", "ana@udc.edu.co", ""));
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarDocente("Luis", "luis@udc.edu.co", null));
    }

    @Test
    void rechazaCorreoDuplicadoEntreEstudiantesYDocentes() {
        servicio.registrarEstudiante("Ana", "ana@udc.edu.co", "1");
        assertThrows(IllegalArgumentException.class,
                () -> servicio.registrarDocente("Ana Docente", "ANA@udc.edu.co", "Sistemas"));
        assertEquals(1, servicio.totalRegistrados());
    }
}
