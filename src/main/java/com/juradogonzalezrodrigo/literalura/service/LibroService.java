package com.juradogonzalezrodrigo.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juradogonzalezrodrigo.literalura.dto.ApiResponseDTO;
import com.juradogonzalezrodrigo.literalura.model.Autor;
import com.juradogonzalezrodrigo.literalura.model.Libro;


public class LibroService {

    // Para llamadas a la API
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String urlBaseAPI = "https://gutendex.com/books";


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

            // Pasar a los modelos

            Autor autor = new Autor(
                    apiResponse.getResults().get(0).getAuthors().get(0).getName(),
                    apiResponse.getResults().get(0).getAuthors().get(0).getBirth_year(),
                    apiResponse.getResults().get(0).getAuthors().get(0).getDeath_year()
            );

            Libro libro = new Libro(
                    apiResponse.getResults().get(0).getTitle(),
                    autor,
                    apiResponse.getResults().get(0).getLanguages().get(0),
                    apiResponse.getResults().get(0).getDownloadCount()
            );

            System.out.println(libro.toString());



        } catch (Exception e) {
            System.out.println("Error al buscar libro: " + e.getMessage());
        }




    }
}
