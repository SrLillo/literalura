package com.aluracursos.literalura.principal;

import java.util.Scanner;

public class Principal {
    Scanner teclado = new Scanner(System.in);

    public void muestraMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                    \n** MENU **
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma

                    9 - Salir
                    """);

            int opcion = Integer.parseInt(teclado.nextLine());

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
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void buscaLibroPorTitulo() {
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
