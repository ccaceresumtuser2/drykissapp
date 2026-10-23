package com.udc.reut.cod.app.drykissapp.kiss.basico.sinsol;

/**
 * EJERCICIO KISS BÁSICO - VERSIÓN SIN SOLUCIÓN (código que viola KISS).
 *
 * <p>Esta clase funciona y pasa las pruebas, pero cada método resuelve un
 * problema trivial de la forma más complicada posible: ciclos innecesarios,
 * banderas, if anidados y comparaciones redundantes con booleanos.</p>
 *
 * <p><b>Tarea del estudiante:</b> simplificar cada método sin cambiar su
 * comportamiento (las pruebas de {@code UtilidadesNumeroTest} deben seguir
 * pasando).</p>
 */
public class UtilidadesNumero {

    /**
     * Indica si un número es par.
     *
     * <p>PROBLEMA KISS: en lugar de usar el operador módulo (%), recorre el
     * número de uno en uno alternando una bandera. Es lento (O(n)) y difícil
     * de leer.</p>
     */
    public boolean esPar(int numero) {
        // Se trabaja con una copia "positiva" del número (paso innecesario)
        long n = numero;
        if (n < 0) {
            n = -n;
        }
        // Bandera que se invierte en cada iteración: par, impar, par, impar...
        boolean resultado = true;
        while (n > 0) {
            n = n - 1;
            resultado = !resultado;
        }
        // Comparación redundante de un booleano con true
        if (resultado == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna el nombre del día de la semana (1 = Lunes ... 7 = Domingo).
     *
     * <p>PROBLEMA KISS: una "pirámide" de if-else anidados que crece hacia la
     * derecha y obliga a leer todas las condiciones para entender el método.</p>
     */
    public String nombreDia(int dia) {
        String nombre = "";
        if (dia == 1) {
            nombre = "Lunes";
        } else {
            if (dia == 2) {
                nombre = "Martes";
            } else {
                if (dia == 3) {
                    nombre = "Miercoles";
                } else {
                    if (dia == 4) {
                        nombre = "Jueves";
                    } else {
                        if (dia == 5) {
                            nombre = "Viernes";
                        } else {
                            if (dia == 6) {
                                nombre = "Sabado";
                            } else {
                                if (dia == 7) {
                                    nombre = "Domingo";
                                } else {
                                    nombre = "Invalido";
                                }
                            }
                        }
                    }
                }
            }
        }
        return nombre;
    }

    /**
     * Retorna el mayor de tres números.
     *
     * <p>PROBLEMA KISS: compara todas las combinaciones posibles a mano
     * cuando la librería estándar ya ofrece {@link Math#max(int, int)}.</p>
     */
    public int mayor(int a, int b, int c) {
        int mayor;
        if (a >= b) {
            if (a >= c) {
                mayor = a;
            } else {
                mayor = c;
            }
        } else {
            if (b >= c) {
                mayor = b;
            } else {
                mayor = c;
            }
        }
        return mayor;
    }
}
