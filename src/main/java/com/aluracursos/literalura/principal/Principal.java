package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.dto.DatosDTO;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    private static final String INVALIDO = "Opción no válida. Por favor, ingresa un número del menú";

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
            }
        }
    }

    private void buscaLibroPorTitulo() {
        System.out.println("Por favor, ingresa el nombre o parte del nombre del libro que deseas buscar");
        String libroBuscado = teclado.nextLine();
        String url = URL_BASE + libroBuscado.replace(" ", "%20");
        var json3 = consumoAPI.obtenerDatos(url);
        var datos3 = conversor.obtenerDatos(json3, DatosDTO.class);
        System.out.println(datos3);
    }

    private void listaLibrosRegistrados() {


    }

    private void listaAutoresRegistrados() {
    }

    private void listaAutoresVivosEnAno() {
    }

    private void listaLibrosPorIdioma() {
    }
}
