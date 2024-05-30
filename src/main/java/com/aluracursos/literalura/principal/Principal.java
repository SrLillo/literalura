package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.modelo.Autor;
import com.aluracursos.literalura.modelo.Datos;
import com.aluracursos.literalura.modelo.DatosLibro;
import com.aluracursos.literalura.modelo.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import com.aluracursos.literalura.service.LibroService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    private static final String INVALIDO = "Opción no válida. Por favor, ingresa un número del menú";
    private final LibroRepository repositorio;
    private final AutorRepository repositorioAutor;
    LibroService libroService = new LibroService();

    public Principal(LibroRepository repository, AutorRepository autorRepository) {
        this.repositorio = repository;
        this.repositorioAutor = autorRepository;
    }

    public void muestraMenu() {
        while (true) {
            int opcion = 0;
            boolean opcionValida = false;
            System.out.println("""
                    ** MENU **
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma

                    9 - Salir
                    """);
            while (!opcionValida) {
                try {
                    opcion = teclado.nextInt();
                    teclado.nextLine();
                    if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5 || opcion == 9) {
                        opcionValida = true;
                    } else {
                        System.out.println(INVALIDO);
                        teclado.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println(INVALIDO);
                    teclado.nextLine();
                }
            }
            switch (opcion) {
                case 1:
                    buscaLibroPorTitulo();
                    break;
                case 2:
                    listaLibrosRegistrados();
                    break;
                case 3:
                    listaAutoresRegistrados();
                    break;
                case 4:
                    listaAutoresVivosEnAno();
                    break;
                case 5:
                    listaLibrosPorIdioma();
                    break;
                case 9:
                    System.out.println("Cerrando la aplicación...");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private void buscaLibroPorTitulo() {
        System.out.println("Por favor, ingresa el nombre o parte del nombre del libro que deseas buscar");
        String tituloLibro = teclado.nextLine();
        String url = URL_BASE + tituloLibro.replace(" ", "+");
        var json = consumoAPI.obtenerDatos(url);
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("\nLibro encontrado: ");
            DatosLibro l = libroBuscado.get();
            Libro libroEncontrado = new Libro(l.getTitulo(), l.getAutores(), l.getIdiomas(), l.getNumeroDeDescargas());
            Optional<Libro> libroExistente = repositorio.findByTitulo(libroEncontrado.getTitulo());
            if (libroExistente.isPresent()) {
                System.out.println("El libro ya existe en la base de datos.");
            } else {
                repositorio.save(libroEncontrado);
                System.out.println(libroEncontrado);
            }
        } else {
            System.out.println("\nLibro no encontrado");
        }
    }

    private void listaLibrosRegistrados() {
        List<Libro> listadoDeLibrosRegistrados = repositorio.findAll();
        System.out.println("\n");
        listadoDeLibrosRegistrados.stream()
                .forEach(l -> System.out.println(l.getTitulo()));
        System.out.println("\n");
    }

    private void listaAutoresRegistrados() {
        List<Autor> listadoDeAutoresRegistrados = repositorioAutor.findAll();
        System.out.println("\n");
        listadoDeAutoresRegistrados.stream()
                        .forEach(a -> System.out.println(a.getNombre()));
        System.out.println("\n");
    }

    private void listaAutoresVivosEnAno() {
        System.out.println("Ingrese el año en el que desea buscar autores vivos:");
        int anio = teclado.nextInt();
        teclado.nextLine(); // To consume the new line character
        List<Autor> autoresVivosEnElAno = repositorioAutor.findAutoresVivosEnAno(anio);
        System.out.println("\n");
        for (Autor autor : autoresVivosEnElAno) {
            System.out.println(autor.getNombre());
        }
        System.out.println("\n");
        if (autoresVivosEnElAno.isEmpty()) {
            System.out.println("No se encontró ningún autor vivo en el año ingresado.");
        }
    }

    private void listaLibrosPorIdioma() {
        System.out.println("""
                        Ingrese el código de idioma en el que desea buscar el libro:
                        en - inglés
                        es - castellano
                        pt - portugués
                        it - italiano
                        fr - francés
                        ru - ruso
                        y así sucesivamente
                        """);
        String idioma = teclado.nextLine();
        List<String> idiomas = List.of(idioma);
        List<Libro> librosPorIdioma = repositorio.findByIdiomas(idiomas);
        System.out.println("\n");
        librosPorIdioma.stream()
                .forEach(l -> System.out.println(l.getTitulo()));
        System.out.println("\n");
    }
}