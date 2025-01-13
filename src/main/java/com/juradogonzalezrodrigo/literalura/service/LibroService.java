package com.juradogonzalezrodrigo.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juradogonzalezrodrigo.literalura.dto.ApiResponseDTO;
import com.juradogonzalezrodrigo.literalura.model.Autor;
import com.juradogonzalezrodrigo.literalura.model.Libro;

import com.juradogonzalezrodrigo.literalura.repository.AutorRepository;
import com.juradogonzalezrodrigo.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            System.out.println("----- LIBRO -----");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor().getNombre());
            System.out.println("Idioma: " + libro.getIdioma());
            System.out.println("Cantidad de descargas: " + libro.getCantDescargas());
            System.out.println("-----------------");

            // System.out.println("Resultado: "+ libro);

            // Guardar en la base de datos
            System.out.println("Guardando en la base de datos...");
            autorRepository.save(autor);
            libroRepository.save(libro);

            // Verificar si se guardaron correctamente
            if (autorRepository.existsById(autor.getId()) && libroRepository.existsById(libro.getId())) {
                System.out.println("Libro y autor guardados exitosamente.");
            } else {
                System.out.println("Error al guardar el libro o el autor.");
            }




        } catch (Exception e) {
            System.out.println("Error al buscar libro: " + e.getMessage());
        }




    }
}
