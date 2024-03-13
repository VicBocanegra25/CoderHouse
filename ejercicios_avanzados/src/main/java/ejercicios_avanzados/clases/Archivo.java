package ejercicios_avanzados.clases;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// Clase correspondiente al ejercicio 52

public class Archivo {

	public Archivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Método para leer archivos. Regresa el contenido en una String
	
	public String leerArchivo(String path_) throws IOException {
		try {
			// Se regresa un String con el contenido del archivo pasado como argumento
			return new String(Files.readAllBytes(Paths.get(path_)), StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new IOException("El archivo no existe. ");
		}
		
	}
}
