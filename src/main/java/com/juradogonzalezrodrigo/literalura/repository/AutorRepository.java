package com.juradogonzalezrodrigo.literalura.repository;

import com.juradogonzalezrodrigo.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombre(String nombre);

}