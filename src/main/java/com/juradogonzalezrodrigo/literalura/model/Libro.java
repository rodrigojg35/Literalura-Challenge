package com.juradogonzalezrodrigo.literalura.model;

import com.juradogonzalezrodrigo.literalura.dto.LibroDTO;
import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private String idioma;

    private int cantDescargas;

    public Libro() {
    }

    public Libro(LibroDTO libro, Autor autor) {
        this.titulo = libro.getTitle();
        this.autor = autor;
        this.idioma = libro.getLanguages().get(0);
        this.cantDescargas = libro.getDownloadCount();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCantDescargas() {
        return cantDescargas;
    }

    public void setCantDescargas(int cantDescargas) {
        this.cantDescargas = cantDescargas;
    }
}