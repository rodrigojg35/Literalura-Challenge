package com.juradogonzalezrodrigo.literalura.principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private int opcionPrincipal;


        public void iniciarMenu() {

            System.out.println();
            System.out.println("**************************************************************");
            System.out.println("Bienvenido a Literalura Challenge: ");
            System.out.println("Creado por Rodrigo Jurado González - Grupo 7 Alura Latam");
            System.out.println("**************************************************************");

            // Paso 1: Iniciar el bucle principal del menú

            while(true){

                System.out.println("Elija la opción deseada ingresando el número correspondiente: ");
                System.out.println("1. Buscar libro por su título");
                System.out.println("2. Listar libros registrados");
                System.out.println("3. Listar autores registrados");
                System.out.println("4. Listar autores vivos en un determinado año (especificar)");
                System.out.println("5. Listar libros por idioma (especificar)");
                System.out.println("0. SALIR");
                System.out.println("**************************************************************");

                // Paso 2: validar la opción ingresada del usuario

                while(true){
                    try {
                        System.out.print("Ingrese la opción deseada: ");
                        System.out.print("--> ");
                        opcionPrincipal = scanner.nextInt();

                        // Opcion dentro del rango
                        if (opcionPrincipal >= 0 && opcionPrincipal <= 5) {
                            break;
                        } else {
                            System.out.println("Por favor, ingrese una opción válida.");
                        }

                    } catch (Exception e) {   // Opcion invalida
                        System.out.println("Por favor, ingrese una opción válida.");
                        scanner.next();
                    }

                }

                // Paso 3: ejecutar la opción seleccionada

                if (opcionPrincipal == 0) {  // Salir del programa
                    System.out.println();
                    System.out.println("Gracias por utilizar Literalura Challenge. Hasta pronto!");
                    System.out.println("**************************************************************");
                    break;
                }

                // Opciones del menú principal
                switch (opcionPrincipal) {
                    // Llamar a los métodos correspondientes
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosEnUnDeterminadoAnio();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                }

                System.out.println();
                System.out.println("Volviendo a mostrar las opciones del menú principal...");
                System.out.println("**************************************************************");
            }




        }

        private void buscarLibroPorTitulo() {
            System.out.println("Ingrese el nombre del libro a buscar: ");
            System.out.print("--> ");
            String titulo = scanner.next();

            System.out.println();
            System.out.println("Buscando... un momento porfavor...");
            System.out.println();


        }

        private void listarLibrosRegistrados() {
            System.out.println("Mostrando libros registrados: ");
            System.out.println();

        }

        private void listarAutoresRegistrados() {
            System.out.println("Listando autores registrados: ");
            System.out.println();

        }

        private void listarAutoresVivosEnUnDeterminadoAnio() {
            int anio = 0;

            System.out.println("Ingrese el año en el que desee buscar autores vivos de esa época: ");

            while(true){ // validar tipo de dato
                try {
                    System.out.print("--> ");
                    anio = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Por favor, ingrese un año válido.");
                    scanner.next();
                }
            }

            System.out.println();
            System.out.println("Buscando autores vivos en el año " + anio + "...");
            System.out.println();


        }

        private void listarLibrosPorIdioma() {
            String idiomaSeleccionado = "" ;

            System.out.println("Ingrese el idioma para buscar los libros: ");

            Map<String, String> idiomas = new HashMap<>();
            idiomas.put("es", "Español");
            idiomas.put("en", "Inglés");
            idiomas.put("fr", "Francés");
            idiomas.put("pt", "Portugués");

            for (Map.Entry<String, String> entry : idiomas.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

            while(true){
                System.out.print("--> ");
                idiomaSeleccionado = scanner.next();

                if(idiomas.containsKey(idiomaSeleccionado)){
                    break;
                } else {
                    System.out.println("Por favor, ingrese un idioma válido.");
                }
            }

            System.out.println();
            System.out.println("Buscando libros en " + idiomas.get(idiomaSeleccionado) + "...");
            System.out.println();


        }
}
