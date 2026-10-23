package com.udc.reut.cod.app.drykissapp.kiss.intermedio.sinsol;

/**
 * EJERCICIO KISS INTERMEDIO - VERSIÓN SIN SOLUCIÓN (código que viola KISS).
 *
 * <p>Calcula el costo de un envío con estas reglas de negocio:</p>
 * <ul>
 *   <li>Tarifa base: NACIONAL = 5000, INTERNACIONAL = 20000.</li>
 *   <li>Por cada kg por encima de 10 kg se cobran 1000 adicionales.</li>
 *   <li>Los clientes premium pagan el 50% del valor.</li>
 *   <li>Peso &lt;= 0 o destino desconocido lanzan IllegalArgumentException.</li>
 * </ul>
 *
 * <p>El método funciona, pero acumula malas prácticas que lo hacen difícil
 * de leer y mantener: banderas, if anidados, lógica repetida en cada rama y
 * un ciclo para hacer una simple resta.</p>
 *
 * <p><b>Tarea del estudiante:</b> reescribir {@link #calcularCosto} usando
 * cláusulas de guarda, sin banderas y sin código duplicado en las ramas.</p>
 */
public class CalculadoraEnvio {

    public double calcularCosto(int pesoKg, String destino, boolean esPremium) {
        // PROBLEMA KISS: bandera de validez que se arrastra por todo el método
        boolean esValido = false;
        double costo = 0;

        if (destino != null) {
            if (pesoKg > 0) {
                esValido = true;
            }
        }

        if (esValido == true) {
            // PROBLEMA KISS: se compara el texto con dos variantes en vez de normalizarlo
            if (destino.equals("NACIONAL") || destino.equals("nacional")
                    || destino.equalsIgnoreCase("NACIONAL")) {
                costo = 5000;
                // PROBLEMA KISS: un ciclo para calcular (peso - 10)
                if (pesoKg > 10) {
                    int kgExtra = 0;
                    for (int i = 11; i <= pesoKg; i++) {
                        kgExtra = kgExtra + 1;
                    }
                    costo = costo + kgExtra * 1000;
                }
                // PROBLEMA KISS: la regla premium se repite en cada rama
                if (esPremium == true) {
                    costo = costo / 2;
                } else {
                    costo = costo * 1;
                }
            } else {
                if (destino.equals("INTERNACIONAL") || destino.equals("internacional")
                        || destino.equalsIgnoreCase("INTERNACIONAL")) {
                    costo = 20000;
                    if (pesoKg > 10) {
                        int kgExtra = 0;
                        for (int i = 11; i <= pesoKg; i++) {
                            kgExtra = kgExtra + 1;
                        }
                        costo = costo + kgExtra * 1000;
                    }
                    if (esPremium == true) {
                        costo = costo / 2;
                    } else {
                        costo = costo * 1;
                    }
                } else {
                    esValido = false;
                }
            }
        }

        // PROBLEMA KISS: el error se decide al final, lejos de la causa
        if (esValido == false) {
            throw new IllegalArgumentException("Datos de envio invalidos");
        }
        return costo;
    }
}
