# Preguntas y respuestas: KISS y DRY

Complemento de [TEORIA.md](TEORIA.md) y de los ejercicios del proyecto.
Las respuestas están ocultas: intente responder primero y luego haga clic en **Ver respuesta**.

**Contenido**
1. [Preguntas conceptuales](#1-preguntas-conceptuales)
2. [Preguntas sobre los ejercicios](#2-preguntas-sobre-los-ejercicios)
3. [Análisis de código](#3-análisis-de-código)
4. [Selección múltiple](#4-selección-múltiple)
5. [Verdadero o falso](#5-verdadero-o-falso)

---

## 1. Preguntas conceptuales

### 1.1 ¿Qué significa KISS y cuál es su idea central?
<details><summary>Ver respuesta</summary>

*Keep It Simple, Stupid*. La mayoría de los sistemas funcionan mejor si se mantienen simples, por lo que
la simplicidad debe ser un objetivo de diseño y se debe evitar la complejidad **innecesaria**.
En software, "simple" significa que el próximo programador entienda el código con facilidad,
lo pruebe y lo modifique sin miedo.
</details>

### 1.2 ¿Qué significa DRY y cómo lo definen sus autores?
<details><summary>Ver respuesta</summary>

*Don't Repeat Yourself*. Hunt y Thomas (*The Pragmatic Programmer*, 1999): **"Todo fragmento de
conocimiento debe tener una representación única, inequívoca y autorizada dentro de un sistema."**
Cada regla o decisión debe estar definida en un solo lugar, para que un cambio se haga una sola vez.
</details>

### 1.3 ¿Por qué DRY habla de "conocimiento" y no de "código"? Dé un ejemplo de duplicación que no sea código.
<details><summary>Ver respuesta</summary>

Porque lo que causa errores no es que dos líneas se parezcan, sino que **una misma regla** esté escrita
en varios lugares. Si la regla cambia, hay que actualizar todas las copias, y olvidar una deja el sistema inconsistente.

Ejemplos de duplicación que no es código:
- Una tabla de base de datos y una clase Java que describen la misma estructura y se mantienen a mano por separado.
- Un comentario que repite lo que hace el método. Si el método cambia, el comentario queda mintiendo.
- Guardar `edad` y `fechaNacimiento`: la edad se deriva de la fecha, así que el mismo dato está dos veces.
- Documentación de una API escrita a mano, separada del código que la implementa.
</details>

### 1.4 Explique la diferencia entre *simple* y *fácil* con un ejemplo.
<details><summary>Ver respuesta</summary>

- **Fácil** es relativo a quien escribe: es lo familiar o lo rápido. Copiar y pegar un método y cambiar una palabra es *fácil*.
- **Simple** es una propiedad del resultado: pocas partes entrelazadas, se entiende de una vez.
  El código copiado **no** es simple, porque ahora hay dos lugares que deben mantenerse sincronizados.

Ejemplo: escribir siete `if` anidados para el nombre del día es *fácil* (no hay que pensar),
pero un arreglo `DIAS[dia - 1]` con una validación de rango es *simple*.
</details>

### 1.5 ¿Qué es YAGNI y qué relación tiene con KISS?
<details><summary>Ver respuesta</summary>

*You Aren't Gonna Need It* ("no lo vas a necesitar"), de Programación Extrema (XP):
no implementar una funcionalidad o abstracción hasta que se necesite de verdad.

Es la aplicación de KISS al **diseño**. Muchas complicaciones vienen de prepararse para requisitos
imaginarios ("por si algún día hay más conversiones"). Ese código especulativo se paga al escribirlo
y cada vez que alguien lo lee, aunque el requisito nunca llegue.
</details>

### 1.6 Mencione cinco síntomas de código que viola KISS.
<details><summary>Ver respuesta</summary>

1. `if` anidados en muchos niveles (código "pirámide").
2. Banderas booleanas que controlan el flujo de todo el método.
3. Reimplementar lo que ya ofrece el lenguaje (ciclos en vez de `%` o `Math.max`).
4. Comparaciones redundantes (`if (x == true) return true; else return false;`).
5. Interfaces, fábricas o singletons sin una necesidad real (sobre-ingeniería).
6. Métodos largos que hacen varias cosas.
7. Números o textos mágicos.
</details>

### 1.7 Mencione cuatro síntomas de código que viola DRY.
<details><summary>Ver respuesta</summary>

1. Métodos con nombres que difieren en una palabra y el mismo cuerpo (`promedioFisica`, `promedioMatematicas`).
2. El mismo literal con significado de negocio repetido (`0.19`, `3.0`, una expresión regular).
3. Clases con los mismos atributos, getters y validaciones.
4. Al corregir un error hay que "acordarse" de corregirlo en otro lugar.
5. Pruebas que se repiten para cubrir cada copia del mismo algoritmo.
</details>

### 1.8 ¿Qué es la duplicación accidental (coincidental) y por qué unificarla es un error?
<details><summary>Ver respuesta</summary>

Es código que **se parece hoy** pero representa **conocimientos distintos**, que cambiarán por razones distintas.
Si se unifica, se acoplan dos reglas independientes: cambiar una rompe la otra.

Ejemplo: el nombre de usuario y el nombre de producto tienen máximo 50 caracteres. Si se crea una sola
constante `MAX_50` y mañana el negocio amplía los productos a 100 caracteres, cambiar la constante
también cambia (sin querer) la regla de los usuarios.

Sandi Metz: *"La duplicación es mucho más barata que la abstracción equivocada."*
</details>

### 1.9 ¿Qué es la "regla de tres" y qué problema evita?
<details><summary>Ver respuesta</summary>

Heurística de Don Roberts, popularizada por Martin Fowler en *Refactoring*:
1. La primera vez, se escribe.
2. La segunda vez, se duplica (con incomodidad).
3. **La tercera vez, se refactoriza.**

Evita la **abstracción prematura**. Con un solo caso, o con dos, no se sabe bien qué es común y qué varía.
Con tres ejemplos, la abstracción tiene más probabilidad de ser la correcta.
</details>

### 1.10 ¿Existe una tensión entre KISS y DRY? Explique.
<details><summary>Ver respuesta</summary>

Sí. Eliminar duplicación (DRY) casi siempre **agrega una abstracción**: un método, una clase, una jerarquía o un patrón.
Cada abstracción agrega complejidad, que va en contra de KISS. Al revés, el código más "directo" a veces se logra copiando.

El equilibrio: **abstraer solo cuando la abstracción quita más complejidad (copias, riesgo de
inconsistencias) de la que agrega.** Los ejercicios avanzados lo muestran: los patrones sobran en
`kiss.avanzado` y se justifican en `dry.avanzado`.
</details>

### 1.11 ¿Por qué es importante tener pruebas **antes** de refactorizar?
<details><summary>Ver respuesta</summary>

Refactorizar es **cambiar la estructura sin cambiar el comportamiento**. Las pruebas son la forma de
comprobar que el comportamiento no cambió: se ejecutan antes (todas pasan), se refactoriza y se ejecutan
otra vez. Si alguna falla, el cambio alteró el comportamiento. Sin pruebas, simplificar o eliminar
duplicación es una apuesta. Por eso, en este proyecto, `sinsol` y `consol` comparten las mismas pruebas.
</details>

### 1.12 ¿Qué significa WET?
<details><summary>Ver respuesta</summary>

Es lo contrario de DRY: *Write Everything Twice* (o, en broma, *We Enjoy Typing*).
Describe código con el mismo conocimiento repetido en muchos lugares.
</details>

---

## 2. Preguntas sobre los ejercicios

### 2.1 (`kiss.basico`) ¿Por qué el método `esPar` de `sinsol` es un problema, además de ser difícil de leer?
<details><summary>Ver respuesta</summary>

Es **O(n)**: recorre el número de uno en uno alternando una bandera. Para `Integer.MAX_VALUE` hace más de
2 000 millones de iteraciones. `numero % 2 == 0` es O(1). La complejidad innecesaria no solo afecta la
legibilidad, también el rendimiento. Por eso `consol` tiene una prueba extra con `Integer.MAX_VALUE`.
</details>

### 2.2 (`kiss.basico`) ¿Qué técnica reemplaza los siete `if` anidados de `nombreDia`?
<details><summary>Ver respuesta</summary>

**Usar una estructura de datos en lugar de condicionales**: un arreglo `DIAS` con los nombres, una
cláusula de guarda para el rango (1 a 7) y un acceso directo `DIAS[dia - 1]`.
</details>

### 2.3 (`kiss.intermedio`) Mencione tres problemas de `CalculadoraEnvio` en `sinsol` y cómo se corrigieron.
<details><summary>Ver respuesta</summary>

| Problema en `sinsol` | Corrección en `consol` |
|---|---|
| Bandera `esValido` que recorre todo el método | Cláusula de guarda al inicio que lanza la excepción |
| `if` anidados en 4 niveles | Flujo lineal: guarda → tarifa → recargo → descuento |
| Un `for` para calcular `peso - 10` | `Math.max(0, pesoKg - PESO_LIBRE_KG)` |
| Recargo y descuento repetidos en cada rama | Se aplican una sola vez, después de elegir la tarifa |
| Tres comparaciones para el mismo texto | `destino.toUpperCase()` en un `switch` |
| Números mágicos (10, 1000, 0.5) | Constantes `PESO_LIBRE_KG`, `RECARGO_POR_KG`, `DESCUENTO_PREMIUM` |
</details>

### 2.4 (`kiss.intermedio`) ¿Qué es una cláusula de guarda y qué ventaja tiene?
<details><summary>Ver respuesta</summary>

Es una condición al **inicio** del método que detecta un caso inválido o especial y termina de inmediato
(`return` o `throw`). Ventajas: elimina la anidación (el resto del método asume datos válidos) y el error
se reporta **cerca de su causa**, no al final del método.
</details>

### 2.5 (`kiss.avanzado`) ¿Qué error que antes ocurría en tiempo de ejecución ahora detecta el compilador? ¿Por qué?
<details><summary>Ver respuesta</summary>

En `sinsol`, la conversión se elige con un código de texto: `servicio.convertir(10, "C_A_F")`.
Si se escribe mal (`"C_a_F"`), el programa compila y **falla al ejecutarse** con `IllegalArgumentException`.

En `consol` se llama a un método con nombre: `ConversorTemperatura.celsiusAFahrenheit(10)`.
Si se escribe mal el nombre, **el código no compila**. El tipo de error desaparece, y con él la prueba que lo cubría.
</details>

### 2.6 (`kiss.avanzado`) ¿Por qué el Singleton `ProveedorFabrica` es innecesario?
<details><summary>Ver respuesta</summary>

Un Singleton se justifica cuando debe existir **una sola instancia** de un recurso costoso o compartido
(una conexión, una configuración global). `FabricaConversores` no tiene estado costoso ni compartido.
El Singleton solo agrega estado global, acoplamiento (todos dependen de `getInstancia()`) y dificultad
para probar, sin aportar nada.
</details>

### 2.7 (`kiss.avanzado` vs `dry.avanzado`) ¿Por qué el Template Method es una mala decisión en un ejercicio y buena en el otro?
<details><summary>Ver respuesta</summary>

- En **`kiss.avanzado`**, `ConversorAbstracto` define un algoritmo con ganchos (`preProcesar`, `postProcesar`)
  que **ninguna subclase usa**. No había duplicación previa ni variaciones reales: el patrón resuelve un
  problema que no existe. Solo agrega complejidad.
- En **`dry.avanzado`**, el algoritmo (validar, recorrer, calcular IVA y total, formatear) **ya estaba
  copiado tres veces** y solo cambiaba la presentación. El patrón elimina esa duplicación real y facilita
  agregar formatos.

Un patrón es bueno o malo según si resuelve un problema **real**.
</details>

### 2.8 (`dry.basico`) Si la nota aprobatoria cambia a 3.5, ¿cuántas líneas hay que editar en cada versión?
<details><summary>Ver respuesta</summary>

- **`sinsol`:** 3 (una en cada método `estadoX`), y el riesgo es olvidar alguna.
- **`consol`:** 1 (la constante `NOTA_APROBATORIA`).

Y si se agrega la materia Química: en `sinsol` hay que copiar dos métodos más; en `consol` la clase no cambia.
</details>

### 2.9 (`dry.intermedio`) ¿Qué ventaja tiene validar en el constructor de `Persona` en lugar de hacerlo en el servicio?
<details><summary>Ver respuesta</summary>

- **Garantiza un invariante:** es imposible crear un `Estudiante` o un `Docente` inválido, sin importar
  quién lo construya (el servicio, una prueba u otra clase futura).
- **Escribe la validación una sola vez** para todos los tipos de persona.
- **Simplifica el servicio**, que solo se ocupa de lo suyo: evitar correos duplicados y guardar.
</details>

### 2.10 (`dry.intermedio`) ¿Qué riesgo concreto tenía la expresión regular del correo copiada en dos métodos?
<details><summary>Ver respuesta</summary>

Si alguien corrige o amplía la regex en `registrarEstudiante` y olvida `registrarDocente`, los estudiantes
y los docentes quedan con **reglas de correo distintas**. El código compila, las pruebas existentes podrían
seguir pasando y nadie lo nota hasta que un usuario reporta el problema.
En `consol` la regex vive solo en `Validador.FORMATO_CORREO`.
</details>

### 2.11 (`dry.avanzado`) ¿Qué hay que hacer para agregar un reporte en formato Markdown en cada versión?
<details><summary>Ver respuesta</summary>

- **`sinsol`:** copiar uno de los métodos `generarX` completo (validación, ciclo, cálculo de IVA y total,
  formato) y cambiar la presentación. Sería la cuarta copia del algoritmo.
- **`consol`:** crear `ReporteMarkdown extends ReporteVenta` e implementar `encabezado()`, `linea(...)` y
  `resumen(...)`. Los cálculos y el recorrido se heredan sin tocarlos.
</details>

### 2.12 (`dry.avanzado`) ¿Por qué `generar` se declara `final` en `ReporteVenta`?
<details><summary>Ver respuesta</summary>

Porque es el **método plantilla**: define el algoritmo común. Al ser `final`, ninguna subclase puede
sobrescribirlo y reintroducir su propia versión del cálculo, lo que volvería a crear la duplicación que se
quería eliminar. Las subclases solo pueden cambiar los pasos variables (`encabezado`, `linea`, `resumen`, `cierre`).
</details>

---

## 3. Análisis de código

Para cada fragmento: ¿qué principio viola? ¿Cómo lo corregiría?

### 3.1
```java
public boolean esMayorDeEdad(int edad) {
    boolean resultado;
    if (edad >= 18) {
        resultado = true;
    } else {
        resultado = false;
    }
    return resultado;
}
```
<details><summary>Ver respuesta</summary>

**Viola KISS:** usa una variable temporal y un `if` para devolver el valor de una condición que ya es booleana.
Además, `18` es un número mágico.
```java
private static final int MAYORIA_DE_EDAD = 18;

public boolean esMayorDeEdad(int edad) {
    return edad >= MAYORIA_DE_EDAD;
}
```
</details>

### 3.2
```java
public double precioConIvaCamisa(double precio)   { return precio * 1.19; }
public double precioConIvaPantalon(double precio) { return precio * 1.19; }
public double precioConIvaZapato(double precio)   { return precio * 1.19; }
```
<details><summary>Ver respuesta</summary>

**Viola DRY:** el mismo conocimiento (cómo se aplica el IVA y su tasa) está tres veces. El tipo de
producto no influye en el cálculo, así que no debe estar en el nombre del método.
```java
private static final double TASA_IVA = 0.19;

public double precioConIva(double precio) {
    return precio * (1 + TASA_IVA);
}
```
</details>

### 3.3
```java
public interface Saludador { String saludar(String nombre); }

public class SaludadorEspanol implements Saludador {
    public String saludar(String nombre) { return "Hola " + nombre; }
}

public class FabricaSaludadores {
    public static Saludador crear() { return new SaludadorEspanol(); }
}

// Uso:
String s = FabricaSaludadores.crear().saludar("Ana");
```
El sistema solo saluda en español y no hay planes de agregar otros idiomas.
<details><summary>Ver respuesta</summary>

**Viola KISS / YAGNI:** una interfaz con una sola implementación y una fábrica que siempre devuelve lo
mismo, para concatenar un texto. Si algún día hay más idiomas, se introduce la abstracción en ese momento.
```java
public String saludar(String nombre) {
    return "Hola " + nombre;
}
```
</details>

### 3.4
```java
public void procesar(Pedido p) {
    if (p != null) {
        if (p.tieneProductos()) {
            if (p.getCliente() != null) {
                if (p.getCliente().estaActivo()) {
                    enviar(p);
                }
            }
        }
    }
}
```
<details><summary>Ver respuesta</summary>

**Viola KISS:** código "pirámide" con 4 niveles de anidación. Se corrige con cláusulas de guarda:
```java
public void procesar(Pedido p) {
    if (p == null || !p.tieneProductos()) return;
    if (p.getCliente() == null || !p.getCliente().estaActivo()) return;
    enviar(p);
}
```
</details>

### 3.5
```java
public class Cliente  { private String nombre; private String telefono; private String direccion; /* getters */ }
public class Proveedor { private String nombre; private String telefono; private String direccion; /* getters */ }

// En ServicioCliente:
if (telefono == null || !telefono.matches("\\d{10}")) throw new IllegalArgumentException();
// En ServicioProveedor:
if (telefono == null || !telefono.matches("\\d{10}")) throw new IllegalArgumentException();
```
<details><summary>Ver respuesta</summary>

**Viola DRY**, en dos niveles:
1. Atributos y getters repetidos en `Cliente` y `Proveedor`.
2. La regla de validación del teléfono (la regex) está copiada en dos servicios.

Corrección (igual que en `dry.intermedio`):
- Extraer los datos comunes. Puede ser una superclase `Contacto`, o mejor un objeto `DatosContacto` por
  composición, si cliente y proveedor no son realmente "el mismo tipo de cosa".
- Mover la validación a un `Validador.telefono(...)` o al constructor de `DatosContacto`.
</details>

### 3.6
```java
public static final int MAX_LONGITUD = 50;

// Usado para validar el nombre de usuario...
if (usuario.length() > MAX_LONGITUD) ...
// ...y también la descripción corta de un producto
if (descripcion.length() > MAX_LONGITUD) ...
```
<details><summary>Ver respuesta</summary>

**Es duplicación accidental mal unificada (abuso de DRY):** las dos reglas valen 50 por coincidencia,
pero son conocimientos distintos. Si el negocio cambia la longitud de la descripción, cambiará sin
querer la del usuario. Lo correcto son dos constantes independientes:
```java
public static final int MAX_LONGITUD_USUARIO = 50;
public static final int MAX_LONGITUD_DESCRIPCION = 50;
```
</details>

---

## 4. Selección múltiple

### 4.1 ¿Quiénes formularon el principio DRY?
a) Kent Beck y Ward Cunningham  b) Andy Hunt y Dave Thomas  c) Martin Fowler  d) Robert C. Martin
<details><summary>Ver respuesta</summary>

**b)** Andy Hunt y Dave Thomas, en *The Pragmatic Programmer* (1999).
</details>

### 4.2 ¿Cuál de estos cambios aplica KISS?
a) Agregar una interfaz para una clase que tiene una sola implementación
b) Reemplazar un ciclo que cuenta caracteres por `texto.length()`
c) Crear una fábrica para instanciar un objeto sin dependencias
d) Agregar ganchos vacíos "por si una subclase los necesita"
<details><summary>Ver respuesta</summary>

**b)** Usar lo que ofrece el lenguaje. Las opciones a, c y d son sobre-ingeniería (violan KISS/YAGNI).
</details>

### 4.3 Dos métodos tienen el mismo código, pero uno calcula la comisión de vendedores y el otro el bono de gerentes, reglas que el área de RR. HH. define por separado. ¿Qué conviene hacer?
a) Unificarlos de inmediato en un solo método
b) Dejarlos separados, porque es probable que sea duplicación accidental
c) Borrar uno de los dos
d) Convertirlos en un Singleton
<details><summary>Ver respuesta</summary>

**b)** Son reglas de negocio distintas que hoy coinciden. Cambiarán por razones distintas, así que unificarlas las acoplaría.
</details>

### 4.4 ¿Qué patrón se usó en `dry.avanzado` para eliminar la duplicación?
a) Singleton  b) Factory Method  c) Template Method  d) Observer
<details><summary>Ver respuesta</summary>

**c)** Template Method: `ReporteVenta.generar` define el algoritmo y las subclases implementan los pasos variables.
</details>

### 4.5 Según la regla de tres, ¿cuándo se debe refactorizar una duplicación?
a) La primera vez que se escribe el código  b) En cuanto aparece la segunda copia
c) Cuando aparece la tercera copia  d) Nunca
<details><summary>Ver respuesta</summary>

**c)** Con tres casos ya se ve qué es común y qué varía.
</details>

### 4.6 ¿Cuál es la mejor medida de que se aplicó bien DRY a una regla de negocio?
a) El archivo tiene menos líneas
b) Si la regla cambia, se edita en un solo lugar
c) Se usó herencia
d) No hay dos líneas de código iguales en el proyecto
<details><summary>Ver respuesta</summary>

**b)** DRY trata de tener una representación única del conocimiento, no de tener menos líneas ni de usar una técnica en particular.
</details>

---

## 5. Verdadero o falso

| # | Afirmación | Respuesta |
|---|---|---|
| 5.1 | El código más corto siempre es el más simple. | <details><summary>Ver</summary>**Falso.** Una línea con varios ternarios anidados es corta pero difícil de leer. Simple significa fácil de entender.</details> |
| 5.2 | DRY se aplica también a la documentación, la configuración y los esquemas de base de datos. | <details><summary>Ver</summary>**Verdadero.** DRY trata de conocimiento, no solo de código.</details> |
| 5.3 | Usar patrones de diseño siempre mejora la calidad del código. | <details><summary>Ver</summary>**Falso.** Un patrón sin un problema real que resolver es sobre-ingeniería (ver `kiss.avanzado`).</details> |
| 5.4 | Si dos fragmentos de código son idénticos, siempre deben unificarse. | <details><summary>Ver</summary>**Falso.** Pueden ser duplicación accidental: conocimientos distintos que coinciden hoy.</details> |
| 5.5 | Refactorizar no debe cambiar el comportamiento observable del programa. | <details><summary>Ver</summary>**Verdadero.** Por eso las pruebas de `sinsol` y `consol` son las mismas.</details> |
| 5.6 | Aplicar DRY puede agregar complejidad al código. | <details><summary>Ver</summary>**Verdadero.** Toda abstracción tiene un costo. Se justifica si quita más complejidad de la que agrega.</details> |
| 5.7 | YAGNI recomienda preparar el código para todos los requisitos futuros posibles. | <details><summary>Ver</summary>**Falso.** Recomienda lo contrario: implementar solo lo que se necesita hoy.</details> |
| 5.8 | Una constante con nombre ayuda a cumplir tanto KISS como DRY. | <details><summary>Ver</summary>**Verdadero.** El nombre explica el significado (KISS) y el valor se define una sola vez (DRY).</details> |
