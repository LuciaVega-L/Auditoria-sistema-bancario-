# Auditoría Sistema Bancario — C++ a Java

Mini ejercicio para la materia de Ingeniería de Software 1, sobre migración de un sistema bancario legacy escrito en C++ a Java, aplicando principios de POO y buenas prácticas de diseño.

## ¿De qué se trata?

Se parte de un código bancario "legacy" en C++ con problemas típicos de un sistema mal diseñado: fugas de memoria, falta de encapsulamiento, y una arquitectura que viola varios principios SOLID. A partir de ahí se hizo:

1. **Auditoría del código C++** (`originla-code/soft1-lab3-auditoria.cpp`): identificación y documentación (con comentarios) de las fugas de memoria y los problemas de diseño del código original.
2. **Rediseño en Java** (`migrated code/soft1-lab3/src/`): se reemplazó el `struct` original por una jerarquía de clases orientada a objetos, corrigiendo los problemas encontrados en la auditoría.

Ejercicio realizado con apoyo de una IA en modo socrático (Gemini) para guiar el análisis del código antes de escribir la solución.
