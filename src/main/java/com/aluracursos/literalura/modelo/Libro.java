package com.aluracursos.literalura.modelo;

import java.util.List;

public class Libro {
    private int id;
    private String titulo;
    private List<String> temas;
    private List<Autor> autores;
    private List<String> estanterias;
    private List<String> idiomas;
    private String tipoDeMedio;
    private Double numeroDeDescargas;

    public Libro() {}

    public Libro(String titulo, List<String> temas, List<Autor> autores, List<String> estanterias, List<String> idiomas, String tipoDeMedio, Double numeroDeDescargas) {
        this.titulo = titulo;
        this.temas = temas;
        this.autores = autores;
        this.estanterias = estanterias;
        this.idiomas = idiomas;
        this.tipoDeMedio = tipoDeMedio;
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(List<String> estanterias) {
        this.estanterias = estanterias;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public String getTipoDeMedio() {
        return tipoDeMedio;
    }

    public void setTipoDeMedio(String tipoDeMedio) {
        this.tipoDeMedio = tipoDeMedio;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", temas=" + temas +
                ", autores=" + autores +
                ", estanterías=" + estanterias +
                ", idiomas=" + idiomas +
                ", tipoDeMedio='" + tipoDeMedio + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';
    }
}
