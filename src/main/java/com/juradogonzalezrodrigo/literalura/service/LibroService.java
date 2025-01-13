package com.juradogonzalezrodrigo.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juradogonzalezrodrigo.literalura.dto.ApiResponseDTO;
import com.juradogonzalezrodrigo.literalura.model.Autor;
import com.juradogonzalezrodrigo.literalura.model.Libro;

import com.juradogonzalezrodrigo.literalura.repository.AutorRepository;
import com.juradogonzalezrodrigo.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final ConsumoAPI consumoApi;
    private final String urlBaseAPI = "https://gutendex.com/books";

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository ) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.consumoApi = new ConsumoAPI();
    }

    public void buscarLibroPorTitulo(String titulo) {

        try {
            // Reemplazar espacios (en caso de haber)
            titulo = titulo.replace(" ", "+");

            // System.out.println("url: " + urlBaseAPI + "?search=" + titulo);

            // Llamar a la API
            String json =
                    consumoApi.obtenerDatos(urlBaseAPI + "?search=" + titulo);

            // Procesar JSON (mapear en DTOS)
            ObjectMapper objectMapper = new ObjectMapper();
            ApiResponseDTO apiResponse = objectMapper.readValue(json, ApiResponseDTO.class);

            if (apiResponse.getResults().isEmpty() || apiResponse.getCount() == 0 ) {
                System.out.println("No se encontraron resultados");
                return;
            }

            // Pasar a los modelos (ocupando primeras posiciones de la lista de libros y autores de este)

            Autor autor = new Autor(apiResponse.getResults().get(0).getAuthors().get(0));
            Libro libro = new Libro (apiResponse.getResults().get(0), autor);

            // Mostrar el libro

            System.out.println("----- LIBRO ENCONTRADO -----");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Cantidad de descargas: " + libro.getCantDescargas());
            System.out.println("-----------------------------");

            // System.out.println("Resultado: "+ libro);

            // Verificar si el libro ya existe en la base de datos
            Optional<Libro> libroExistente = libroRepository.findByTitulo(libro.getTitulo());

            if (libroExistente.isPresent()) {

                System.out.println("El libro ya existe en la base de datos.");
                return;

            }

            // Guardar en la base de datos
            System.out.println("Guardando libro en la base de datos...");

            // Verificar si el autor ya existe en la base de datos
            Optional<Autor> autorExistente = autorRepository.findByNombre(autor.getNombre());

            if (autorExistente.isPresent()) {
                // si ya existe el autor, se reemplaza el autor del libro por el autor YA existente
                autor = autorExistente.get();

            } else {
                // si no existe el autor, se guarda el autor en la base de datos tambien
                autorRepository.save(autor);

            }
            // sobreescritura del autor del libro y guardar libro
            libro.setAutor(autor);
            libroRepository.save(libro);


            // Verificar si se guardaron correctamente
            if (autorRepository.existsById(autor.getId()) && libroRepository.existsById(libro.getId())) {
                System.out.println("Datos guardados exitosamente.");
            } else {
                System.out.println("Error al guardar el libro o el autor.");
            }


        } catch (Exception e) {
            System.out.println("Error al buscar libro: " + e.getMessage());
        }




    }

    public void listarLibrosRegistrados(){

        List<Libro> listaDelibros = libroRepository.findAllByOrderByTituloAsc();

        for (Libro libro : listaDelibros ) {
            System.out.println("----- LIBRO -----");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Cantidad de descargas: " + libro.getCantDescargas());
            System.out.println("-----------------");
        }


    }

    public void listarLibrosPorIdioma(String idioma){

        List<Libro> listaDelibros = libroRepository.findByIdiomaOrderByTituloAsc(idioma);

        // Organizar alfabeticamente los libros antes de imprimirlos
        listaDelibros = listaDelibros.stream()
                                     .sorted(Comparator.comparing(Libro::getTitulo))
                                     .collect(Collectors.toList());

        for (Libro libro : listaDelibros ) {
            System.out.println("----- LIBRO -----");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Cantidad de descargas: " + libro.getCantDescargas());
            System.out.println("-----------------");
        }



    }

}
