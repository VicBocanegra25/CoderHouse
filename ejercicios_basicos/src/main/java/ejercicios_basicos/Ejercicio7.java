package ejercicios_basicos;

import java.util.Random;

// Escribe un programa que determine si un número es par o impar e imprima el resultado.


public class Ejercicio7 {

	public static void main(String[] args) {
		// Generamos un número aleatorio
		Random rand = new Random();
		int numAleatorio = rand.nextInt();
		
		// Se implementa el control de flujo que imprime "Par" o "Impar" dependiendo del número (se utiliza el operador módulo)
		if (numAleatorio % 2 == 0) {
			System.out.println("El número " + numAleatorio + " es par.");
		} else {
			System.out.println("El número " + numAleatorio + " es impar.");
		}
	}

}
