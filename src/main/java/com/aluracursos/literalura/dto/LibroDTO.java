package com.aluracursos.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        @JsonAlias("title") String titulo,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("authors") List<AutorDTO> autores,
        @JsonAlias("bookshelves") List<String> estanterías,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("media_type") String tipoDeMedio,
        @JsonAlias("download_count") Double numeroDeDescargas) {
}
