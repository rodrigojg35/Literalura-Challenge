package com.juradogonzalezrodrigo.literalura.repository;

import com.juradogonzalezrodrigo.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}