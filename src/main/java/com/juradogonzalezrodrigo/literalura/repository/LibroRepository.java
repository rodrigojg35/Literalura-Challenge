package com.juradogonzalezrodrigo.literalura.repository;

import com.juradogonzalezrodrigo.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}