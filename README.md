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
- **Dto**: Modelos para un enfoque usando DTOs (data transfer object), y poder deserializar de una manera limpia
- **Model**: Contiene las clases que representan los objetos de la aplicación, mismos que se usarán de entidades para funcionar con Entity Manager al mapear la BD
- **Repository**: Contiene las interfaces que extienden de JpaRepository para la persistencia de los objetos
- **Service**: Contiene las clases que realizan la lógica detrás de cada opción en el menú
- **Config**: Contiene las clases de configuración de la aplicación
- **Principal**: Contiene la clase principal con el menu de opciones y entradas básicas a la interacción con el usuario

No se cuenta con un controlador debido a que no es aplicación web

## 2. Funcionalidades
La aplicación cuenta con las siguientes funcionalidades:

- **Buscar libros**: Permite buscar libros por su título desde la API, lo cual los baja a la Base de datos (si es que no estan repetidos) al igual que su respectivo autor
- **Listar libros**: Permite listar los libros almacenados en la base de datos  ordenados alfabeticamente
- **Listar autores**: Permite listar los autores almacenados en la base de datos  ordenados alfabeticamente
- **Listar autores vivos en determinado año**: Permite listar los autores almacenados en la base de datos que estuvieran vivos en el periodo del año ingresado
- **Listar libros por idioma**: Permite listar los libros que tengan de idioma el que se especifique solamente (y ordenados alfabeticamente)
- **Salir**: Permite salir de la aplicación

## 3. Consideraciones
Hay que tener en guenta que la lógica que se manejó no permite repetir autores (si se insertan 2 libros con mismo autor, la segunda inserción sólo insertará el libro, pues se inserta al autor solo una vez, pero ambos libros referenciarán a este mismo)

Las queries construidas en los repositorios están hechas como derived queries (tal como se especifica en el trello)

Las validaciones de tipos de dato y rangos funcionan bien, no permitiendo al usuario ingresar datos no lógicos al contexto que se pida (un entero cuando se pida un nombre, o un nombre cuando se pida un número o año, etc) además de que validan cuando los resultados son vacíos (como en el caso de correr por primera vez el programa teniendo la base de datos vacía, las opciones de listar libros de la bd arrojan un mensaje indicando una respuesta vacía)

Los idiomas configurados solo fueron esos por simplicidad ya que no me vinieron a la mente tantos libros y no vi mas idiomas que los que puse ahí, nuevamente, al buscar por idioma tambien lo ordena.
Aunque pude hacer todas las consuttas con las derived queries (y con jpql) ya con un order by, en algunos casos decidí dejar esa parte con streams para aplicar todo.

Agradezco mucho la atención y retroalimentación para este proyecto, a quien guste.

Rodrigo Jurado.

