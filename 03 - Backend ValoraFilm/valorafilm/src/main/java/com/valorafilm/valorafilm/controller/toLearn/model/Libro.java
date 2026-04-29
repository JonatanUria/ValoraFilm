package com.valorafilm.valorafilm.controller.toLearn.model;

import java.io.Serializable;

public class Libro implements Serializable {

    private String titulo;
    private String autor;
    private String genero;
    private String editorial;
    private String fechaPublicacion;
    private int numeroPaginas;

    public Libro () {}

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
