package com.aluracursos.literalura.dto;

public record AutorDTO(
        String nombre,
        String fechaDeNacimiento,
        String fechaDeFallecimiento) {

    public String getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
}