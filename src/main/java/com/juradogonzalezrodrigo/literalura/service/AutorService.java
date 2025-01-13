package com.juradogonzalezrodrigo.literalura.service;

import com.juradogonzalezrodrigo.literalura.repository.AutorRepository;
import com.juradogonzalezrodrigo.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    }

    public void listarAutoresVivosEnUnDeterminadoAnio(int anio) {

    }

}
