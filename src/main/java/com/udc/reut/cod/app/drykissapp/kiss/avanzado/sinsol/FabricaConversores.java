package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

import java.util.HashMap;
import java.util.Map;

/**
 * Fábrica que registra conversores en un mapa usando códigos de texto.
 *
 * <p>PROBLEMA KISS: el cliente ya no llama a un método con nombre claro, sino
 * que pasa un String "mágico" ("C_A_F"). Un error de tipeo solo se descubre
 * en tiempo de ejecución.</p>
 */
public class FabricaConversores {

    private final Map<String, Conversor> registro = new HashMap<>();

    public FabricaConversores() {
        registrar(new ConversorCelsiusAFahrenheit());
        registrar(new ConversorFahrenheitACelsius());
    }

    public void registrar(Conversor conversor) {
        registro.put(conversor.getCodigo(), conversor);
    }

    public Conversor crear(String codigo) {
        Conversor conversor = registro.get(codigo);
        if (conversor == null) {
            throw new IllegalArgumentException("Conversor no soportado: " + codigo);
        }
        return conversor;
    }
}
