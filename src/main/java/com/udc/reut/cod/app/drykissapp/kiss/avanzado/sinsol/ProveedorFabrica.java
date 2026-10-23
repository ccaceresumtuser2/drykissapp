package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/**
 * Singleton que entrega la única instancia de la fábrica.
 *
 * <p>PROBLEMA KISS: estado global innecesario. La fábrica no tiene estado
 * costoso de crear, por lo que el Singleton solo agrega acoplamiento y
 * dificulta las pruebas.</p>
 */
public final class ProveedorFabrica {

    private static ProveedorFabrica instancia;
    private final FabricaConversores fabrica = new FabricaConversores();

    private ProveedorFabrica() {
    }

    public static synchronized ProveedorFabrica getInstancia() {
        if (instancia == null) {
            instancia = new ProveedorFabrica();
        }
        return instancia;
    }

    public FabricaConversores getFabrica() {
        return fabrica;
    }
}
