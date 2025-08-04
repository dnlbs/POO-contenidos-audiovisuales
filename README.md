Proyecto POO - Sistema de Gestión de Contenidos Audiovisuales
Universidad Politécnica Salesiana

Este proyecto implementa un sistema de gestión para contenidos audiovisuales (películas, series y documentales) utilizando programación orientada a objetos en Java. El sistema permite crear, almacenar y cargar los contenidos desde archivos CSV.

Estructura del Sistema

El proyecto está organizado en tres capas principales:

Modelo: Contiene las clases base como ContenidoAudiovisual (clase abstracta) y sus subclases Pelicula, SerieTV y Documental, además de clases complementarias como Actor e Investigador.

Utilidades: Incluye la clase FileManager para manejar la persistencia en archivos CSV mediante la interfaz ExportableACSV.

Pruebas: La clase PruebaAudioVisual demuestra el funcionamiento del sistema.

Funcionalidades Clave

Serialización y deserialización automática a formato CSV

Validación de datos en los setters de las clases

Jerarquía de clases bien definida con herencia

Manejo de relaciones entre objetos (ej: actores en películas)

Cambios Relevantes

Se implementó el patrón ExportableACSV para estandarizar la importación/exportación CSV.

Se corrigieron errores en la carga de archivos, mejorando el manejo de excepciones.

Se optimizó la estructura de clases para evitar duplicación de código.

Documentación Adicional

El sistema incluye un diagrama de clases (disponible en la carpeta docs) que muestra las relaciones entre los componentes principales. Los archivos CSV generados siguen un formato específico documentado internamente.

Instrucciones para Futuras Mejoras

Para contribuir al proyecto, se recomienda:

Implementar pruebas unitarias más exhaustivas

Añadir soporte para bases de datos

Mejorar la interfaz de usuario

Este proyecto sigue los principios SOLID y está licenciado bajo MIT License.
