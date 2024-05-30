package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainingIgnoreCase(String tituloLibro);
    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findAll();
    @Query("SELECT l FROM Libro l WHERE l.idiomas IN (:idiomaParam)")
    List<Libro> findByIdiomas(@Param("idiomaParam") List<String> idiomas);
}