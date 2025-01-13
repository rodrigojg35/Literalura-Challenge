package com.juradogonzalezrodrigo.literalura.model;

public record Libro(
        String titulo,
        Autor autor,
        String idioma,
        int cantDescargas
) {

}