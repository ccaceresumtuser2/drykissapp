package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/**
 * "Contexto" del patrón Strategy que solo guarda un conversor y lo ejecuta.
 *
 * <p>PROBLEMA KISS: una clase intermediaria que no aporta comportamiento.</p>
 */
public class ContextoConversion {

    private Conversor estrategia;

    public void setEstrategia(Conversor estrategia) {
        this.estrategia = estrategia;
    }

    public double ejecutar(double valor) {
        return estrategia.convertir(valor);
    }
}
