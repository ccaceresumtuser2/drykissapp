# DRY intermedio — con solución

**Paquete:** `com.udc.reut.cod.app.drykissapp.dry.intermedio.consol`

## Solución
- **`Persona` (abstracta):** contiene `nombre`, `correo`, sus getters y su validación, una sola vez.
  Validar en el constructor garantiza que no puede existir una persona inválida.
- **`Estudiante` / `Docente`:** heredan de `Persona` y solo declaran lo que los diferencia.
- **`Validador`:** única fuente de verdad para "campo obligatorio" (reutilizado para nombre, código y departamento)
  y para el formato del correo (un solo `Pattern` precompilado).
- **`ServicioRegistro`:** una sola `List<Persona>` y un método genérico privado `registrar` con la
  lógica común; los métodos públicos se reducen a una línea.

Las pruebas son idénticas a las de `sinsol`.

## Diagrama de clases
```mermaid
classDiagram
    class Validador {
        <<utility>>
        -FORMATO_CORREO: Pattern$
        +obligatorio(valor: String, campo: String)$ String
        +correo(correo: String)$ String
    }
    class Persona {
        <<abstract>>
        -nombre: String
        -correo: String
        #Persona(nombre: String, correo: String)
        +getNombre() String
        +getCorreo() String
    }
    class Estudiante {
        -codigo: String
        +getCodigo() String
    }
    class Docente {
        -departamento: String
        +getDepartamento() String
    }
    class ServicioRegistro {
        -personas: List~Persona~
        +registrarEstudiante(nombre, correo, codigo) Estudiante
        +registrarDocente(nombre, correo, departamento) Docente
        -registrar(persona: T) T
        +existeCorreo(correo: String) boolean
        +totalRegistrados() int
    }

    Persona <|-- Estudiante
    Persona <|-- Docente
    Persona ..> Validador : usa
    Estudiante ..> Validador : usa
    Docente ..> Validador : usa
    ServicioRegistro o-- "*" Persona
```
