package com.aluracursos.literalura;

import com.aluracursos.literalura.principal.Principal;
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
/*		var consumoAPI = new ConsumoAPI();
		var conversor = new ConvierteDatos();

		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/");
		var datos = conversor.obtenerDatos(json, DatosDTO.class);
		System.out.println(datos);

		var json1 = consumoAPI.obtenerDatos("https://gutendex.com/books/31332/");
		var datos1 = conversor.obtenerDatos(json1, LibroDTO.class);
		System.out.println(datos1);

		var json3 = consumoAPI.obtenerDatos("https://gutendex.com/books/?search=divina");
		var datos3 = conversor.obtenerDatos(json3, DatosDTO.class);
		System.out.println(datos3);
*/
		Principal principal = new Principal();
		principal.muestraMenu();
	}
}
