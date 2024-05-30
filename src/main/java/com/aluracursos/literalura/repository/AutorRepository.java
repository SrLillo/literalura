package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findAll();
    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :year AND (a.fechaDeFallecimiento IS NULL OR a.fechaDeFallecimiento >= :year)")
    List<Autor> findAutoresVivosEnAno(@Param("year") int year);
}