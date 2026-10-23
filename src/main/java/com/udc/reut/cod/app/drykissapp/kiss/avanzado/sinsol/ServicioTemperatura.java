package com.udc.reut.cod.app.drykissapp.kiss.avanzado.sinsol;

/**
 * Fachada que el cliente usa para convertir temperaturas.
 *
 * <p>Para hacer una multiplicación y una suma se recorre: Fachada -&gt;
 * Singleton -&gt; Fábrica -&gt; Contexto -&gt; Clase abstracta -&gt; Implementación.</p>
 *
 * <p><b>Tarea del estudiante:</b> reemplazar los 8 tipos de este paquete por
 * la solución más simple que siga pasando las pruebas de conversión.</p>
 */
public class ServicioTemperatura {

    public double convertir(double valor, String codigo) {
        FabricaConversores fabrica = ProveedorFabrica.getInstancia().getFabrica();
        ContextoConversion contexto = new ContextoConversion();
        contexto.setEstrategia(fabrica.crear(codigo));
        return contexto.ejecutar(valor);
    }
}
