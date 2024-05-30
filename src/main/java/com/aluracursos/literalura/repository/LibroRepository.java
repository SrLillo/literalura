package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainingIgnoreCase(String tituloLibro);

    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findAll();
}
