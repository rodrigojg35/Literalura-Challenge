*******************************************
Bienvenidos a mi proyecto:
Literalura para el Challenge de Alura Latam Oracle Next One
*******************************************
```
Me llamo Rodrigo Jurado González y este es mi proyecto para el challenge

## Descripción
Este proyecto es una aplicación de consola realizado usando el java Spring con el fin de crear un buscador
de libros de una API (Gutendex), almacenar los resultados en una base de datos (PostgreSQL) y mostrarlos en pantalla.
Todo mediante el uso de liberias como Jackson para deserializar, JPA para la persistencia y Spring Shell para la interacción con el usuario
y JPQL para las consultas a la base de datos orientadas a objetos.

A continuación explicaré los diferentes apartados de mi proyecto:

## 1. Estructura del proyecto
El proyecto está dividido en diferentes subpaquetes siguiendo uns estructura base MVC
- **Model**: Contiene las clases que representan los objetos de la aplicación
- **Repository**: Contiene las interfaces que extienden de JpaRepository para la persistencia de los objetos
- **Service**: Contiene las clases que realizan la lógica de negocio
- **Config**: Contiene las clases de configuración de la aplicación
- **Principal**: Contiene la clase principal con el menu de opciones y entradas básicas a la interacción con el usuario

No se cuenta con un controlador debido a que no es aplicación web

## 2. Funcionalidades
La aplicación cuenta con las siguientes funcionalidades:

- **Buscar libros**: Permite buscar libros por autor, título o idioma
- **Listar libros**: Permite listar los libros almacenados en la base de datos
- **Mostrar libro**: Permite mostrar la información de un libro en concreto
- **Salir**: Permite salir de la aplicación
