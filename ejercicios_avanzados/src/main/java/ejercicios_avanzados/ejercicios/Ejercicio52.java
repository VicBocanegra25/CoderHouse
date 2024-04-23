package ejercicios_avanzados.ejercicios;

import java.io.IOException;

import ejercicios_avanzados.clases.Archivo;

/* 
 * Define una clase Archivo con un método leerArchivo() que simule la lectura de un archivo y lance 
 * una excepción en caso de que el archivo no exista.
 */

public class Ejercicio52 {
	public static void main(String[] args) throws IOException {
		// Instanciamos el lector de archivos
		Archivo lectorArchivos = new Archivo();
		
		// Declaramos nuestro path para localizar nuestro archivo
		String archivoALeer = "/home/vicbocanegra/CoderHouse/CoderHouse/ejercicios_avanzados/src/main/java/ejercicios_avanzados/auxiliares/Ejercicio51LeerArchivo.txt";
		String archivoNoExistente = "NADA";
		
		System.out.println("El archivo contiene: " + lectorArchivos.leerArchivo(archivoALeer));
		System.out.println("El archivo contiene: " + lectorArchivos.leerArchivo(archivoNoExistente));
	}
}
