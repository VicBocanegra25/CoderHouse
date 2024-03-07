package ejercicios_basicos;

import java.util.Scanner;

// Escribe un programa que solicite al usuario ingresar su edad y determine si es mayor de edad (18 años o más) o no.

public class Ejercicio12 {
	public static void main(String[] args) {
		// Creating a scanner object to gather input from the user (String)
		Scanner scan = new Scanner(System.in);
		
		// Preguntando al usuario por su edad: 
		System.out.println("Ingresa tu edad: \n >>>");
		
		// Guardamos el entero en una variable
		int edadUsuario = scan.nextInt();
		
		// Evaluamos si la edad proporcionada por el usuario es mayor a 18
		String mensajeFinal;
		
		// Validación utilizando if / else
		if(edadUsuario >= 18) {
			mensajeFinal = "Eres mayor de edad";
		} else if (edadUsuario < 0) {
			mensajeFinal = "La edad es incorrecta (el valor ingresado es negativo)";
		} else {
			mensajeFinal = "Eres menor de edad";
		}
		
		System.out.println(mensajeFinal);
	}
	
}
