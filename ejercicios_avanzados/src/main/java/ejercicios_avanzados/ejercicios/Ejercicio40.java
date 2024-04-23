package ejercicios_avanzados.ejercicios;

import java.util.Scanner;

/*
 * Escribe un programa que tome una cadena como entrada y convierta su contenido 
 * a un número entero. Maneja la excepción en caso de que la cadena no sea un número 
 * válido e imprime un mensaje adecuado en caso de que ocurra esta situación.
 */
public class Ejercicio40 {
	public static void main(String[] args) {
		// Utilizamos el objeto Scanner para obtener input del usuario
		Scanner scan = new Scanner(System.in);
		// Enviamos un mensaje al usuario solicitando un número entero
		System.out.print("Ingrese un número entero: ");
		// Y lo almacenamos en una variable int
		String numeroIngresadoString = scan.next();
		// Envolvemos la conversión en un try-catch
		try {
			// Utilizamos el método parseInt() de la clase Integer
			int numeroEntero = Integer.parseInt(numeroIngresadoString);
			System.out.println("El número ingresado es " + numeroEntero);
		} catch (NumberFormatException e) {
			System.err.println("No se pudo transformar el valor ingresado a entero " + e.getMessage());
		}
		
		
	}

}
