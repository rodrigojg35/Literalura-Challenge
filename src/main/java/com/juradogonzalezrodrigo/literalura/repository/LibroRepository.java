package com.juradogonzalezrodrigo.literalura.repository;

import com.juradogonzalezrodrigo.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Derived queries

    List<Libro> findAllByOrderByTituloAsc();
    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findByIdiomaOrderByTituloAsc(String idioma);



}