package com.aluracursos.literalura.service;

import com.aluracursos.literalura.dto.LibroDTO;
import com.aluracursos.literalura.modelo.Autor;
import com.aluracursos.literalura.modelo.DatosAutor;
import com.aluracursos.literalura.modelo.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repository;
    @Autowired
    private AutorRepository autorRepository;

    public Libro convertirLibroDTOALibro(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        List<Autor> autores = new ArrayList<>();
        for (DatosAutor datosAutor : libroDTO.getAutores()) {
            Autor autor = new Autor();
            autor.setNombre(datosAutor.getNombre());
            autor.setFechaDeNacimiento(datosAutor.getFechaDeNacimiento());
            autor.setFechaDeFallecimiento(datosAutor.getFechaDeFallecimiento());
            autorRepository.save(autor);
            autores.add(autor);
        }
        libro.setAutores(autores);
        return libro;
    }

    public List<Autor> findAutoresVivosEnAno(int year) {
        return autorRepository.findAutoresVivosEnAno(year);
    }
}
