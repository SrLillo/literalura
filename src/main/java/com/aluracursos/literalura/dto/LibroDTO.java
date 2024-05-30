package com.aluracursos.literalura.dto;

import com.aluracursos.literalura.modelo.DatosAutor;

import java.util.List;

public record LibroDTO(
        String titulo,
        List<DatosAutor> autores,
        List<String> idiomas,
        Double numeroDeDescargas) {

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public List<DatosAutor> getAutores() {
        return autores;
    }

    public String getTitulo() {
        return titulo;
    }
}
