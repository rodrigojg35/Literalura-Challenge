package com.juradogonzalezrodrigo.literalura.service;

import com.juradogonzalezrodrigo.literalura.model.Autor;
import com.juradogonzalezrodrigo.literalura.model.Libro;
import com.juradogonzalezrodrigo.literalura.repository.AutorRepository;
import com.juradogonzalezrodrigo.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(LibroRepository libroRepository, AutorRepository autorRepository ) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void listarAutoresRegistrados() {

        List<Autor> listaAutores = autorRepository.findAllByOrderByNombreAsc();

        if (listaAutores.isEmpty()) {
            System.out.println("No hay autores registrados");
            return;
        }

        imprimirListaDeAutores(listaAutores);

    }

    public void listarAutoresVivosEnUnDeterminadoAnio(int anio) {

        List<Autor> listaAutores =
                autorRepository.findByFechaNacimientoLessThanEqualAndFechaFallecimientoGreaterThanEqual(anio, anio);

        if (listaAutores.isEmpty()) {
            System.out.println("No hay autores registrados en esas fechas");
            return;
        }

        listaAutores = listaAutores.stream()
                .sorted((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()))
                .toList();

        imprimirListaDeAutores(listaAutores);
    }


    private void imprimirListaDeAutores(List<Autor> listaDeAutores) {
        for (Autor autor : listaDeAutores ) {
            System.out.println("----- Autor -----");
            System.out.println("Nombre: " + autor.getNombre());
            System.out.println("Fecha nacimiento: " + autor.getFechaNacimiento());
            System.out.println("Fecha fallecimiento: " + autor.getFechaFallecimiento());
            System.out.println("-----------------");
        }
    }

}
