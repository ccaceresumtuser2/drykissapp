# Ejercicios KISS y DRY

Base de paquetes: `com.udc.reut.cod.app.drykissapp`

Cada ejercicio tiene dos paquetes:
- **`sinsol`**: código que funciona pero viola el principio. Es el punto de partida del estudiante.
- **`consol`**: la versión refactorizada.

📘 **Teoría:** ver [TEORIA.md](TEORIA.md) (definiciones, síntomas, técnicas, tensión KISS vs DRY y preguntas de repaso).
❓ **Preguntas y respuestas:** ver [PREGUNTAS.md](PREGUNTAS.md) (conceptuales, sobre los ejercicios, análisis de código, selección múltiple y verdadero/falso).

Ambos tienen las **mismas pruebas JUnit 5**: refactorizar es cambiar la estructura sin cambiar el comportamiento.
Cada paquete tiene un `README.md` con el enunciado o la explicación y su **diagrama de clases** (Mermaid).
Los mismos diagramas están en draw.io, una pestaña por paquete, en [diagramadeclase/diagramas-kiss-dry.drawio](diagramadeclase/diagramas-kiss-dry.drawio).

| Principio | Nivel | Sin solución | Con solución | Tema |
|---|---|---|---|---|
| KISS | Básico | [kiss/basico/sinsol](src/main/java/com/udc/reut/cod/app/drykissapp/kiss/basico/sinsol/README.md) | [kiss/basico/consol](src/main/java/com/udc/reut/cod/app/drykissapp/kiss/basico/consol/README.md) | Utilidades numéricas: ciclos e if innecesarios |
| KISS | Intermedio | [kiss/intermedio/sinsol](src/main/java/com/udc/reut/cod/app/drykissapp/kiss/intermedio/sinsol/README.md) | [kiss/intermedio/consol](src/main/java/com/udc/reut/cod/app/drykissapp/kiss/intermedio/consol/README.md) | Costo de envío: banderas, if anidados, cláusulas de guarda |
| KISS | Avanzado | [kiss/avanzado/sinsol](src/main/java/com/udc/reut/cod/app/drykissapp/kiss/avanzado/sinsol/README.md) | [kiss/avanzado/consol](src/main/java/com/udc/reut/cod/app/drykissapp/kiss/avanzado/consol/README.md) | Conversor de temperatura: sobre-ingeniería y YAGNI |
| DRY | Básico | [dry/basico/sinsol](src/main/java/com/udc/reut/cod/app/drykissapp/dry/basico/sinsol/README.md) | [dry/basico/consol](src/main/java/com/udc/reut/cod/app/drykissapp/dry/basico/consol/README.md) | Promedio de notas: métodos copiados y números mágicos |
| DRY | Intermedio | [dry/intermedio/sinsol](src/main/java/com/udc/reut/cod/app/drykissapp/dry/intermedio/sinsol/README.md) | [dry/intermedio/consol](src/main/java/com/udc/reut/cod/app/drykissapp/dry/intermedio/consol/README.md) | Registro de personas: herencia y validador común |
| DRY | Avanzado | [dry/avanzado/sinsol](src/main/java/com/udc/reut/cod/app/drykissapp/dry/avanzado/sinsol/README.md) | [dry/avanzado/consol](src/main/java/com/udc/reut/cod/app/drykissapp/dry/avanzado/consol/README.md) | Reportes de venta: patrón Template Method |

## Ejecutar las pruebas
```bash
mvn test
```

## Dinámica sugerida para la clase
1. El estudiante lee el `README.md` del paquete `sinsol` y ejecuta sus pruebas (todas pasan).
2. Refactoriza el código del paquete `sinsol`.
3. Vuelve a ejecutar las pruebas: deben seguir pasando.
4. Compara su versión con el paquete `consol` y su diagrama de clases.
