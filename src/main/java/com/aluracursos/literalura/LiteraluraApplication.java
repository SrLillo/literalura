package com.aluracursos.literalura;

import com.aluracursos.literalura.dto.DatosDTO;
import com.aluracursos.literalura.dto.LibroDTO;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/");
		System.out.println(json);

		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosDTO.class);
		System.out.println(datos);

		var json1 = consumoAPI.obtenerDatos("https://gutendex.com/books/31332/");
		var datos1 = conversor.obtenerDatos(json1, LibroDTO.class);
		System.out.println(datos1);
	}
}
