package ejercicios_basicos;

import java.util.Scanner;

// Escribe un programa que determine si un año ingresado por el usuario es bisiesto o no.

public class Ejercicio17 {

	public static void main(String[] args) {
		// Solicitamos input al usuario con la clase scanner
		Scanner scan = new Scanner(System.in);
		System.out.print("Ingrese el año a evaluar: ");
		int anio = scan.nextInt();
		
		// Utilizamos control de flujo e imprimimos el mensaje apropiado
		if (esBisiesto(anio))
		{
			System.out.println("El año ingresado, " + anio + ", es bisiesto.");
		} else {
			System.out.println("El año ingresado, " + anio + ", NO es bisiesto.");
		}
		
	}
	
	public static boolean esBisiesto(int anio) {
		// Utilizamos el operador ternario para regresar true o false dependiendo del año ingresado
		return ((anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0))) ? true : false;
	}
}
