package com.udc.reut.cod.app.drykissapp.kiss.intermedio.consol;

/**
 * EJERCICIO KISS INTERMEDIO - VERSIÓN CON SOLUCIÓN.
 *
 * <p>Mismas reglas que la versión sin solución, pero el método se lee de
 * arriba hacia abajo como la descripción del negocio:</p>
 * <ol>
 *   <li>Cláusulas de guarda: los datos inválidos se rechazan al inicio.</li>
 *   <li>Tarifa base según destino (un solo switch).</li>
 *   <li>Recargo por peso (una resta, no un ciclo).</li>
 *   <li>Descuento premium (aplicado una sola vez).</li>
 * </ol>
 */
public class CalculadoraEnvio {

    private static final int PESO_LIBRE_KG = 10;
    private static final double RECARGO_POR_KG = 1000;
    private static final double DESCUENTO_PREMIUM = 0.5;

    public double calcularCosto(int pesoKg, String destino, boolean esPremium) {
        // 1. Guardas: fallar rápido y cerca de la causa
        if (pesoKg <= 0 || destino == null) {
            throw new IllegalArgumentException("Datos de envio invalidos");
        }

        // 2. Tarifa base
        double costo = tarifaBase(destino);

        // 3. Recargo: Math.max evita el if y el ciclo
        costo += Math.max(0, pesoKg - PESO_LIBRE_KG) * RECARGO_POR_KG;

        // 4. Descuento premium
        return esPremium ? costo * DESCUENTO_PREMIUM : costo;
    }

    /** Normaliza el texto una sola vez y decide la tarifa con un switch. */
    private double tarifaBase(String destino) {
        return switch (destino.toUpperCase()) {
            case "NACIONAL" -> 5000;
            case "INTERNACIONAL" -> 20000;
            default -> throw new IllegalArgumentException("Datos de envio invalidos");
        };
    }
}
