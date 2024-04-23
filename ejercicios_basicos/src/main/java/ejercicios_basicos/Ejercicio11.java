package ejercicios_basicos;

import java.util.Random;

/* 
 * Declara e inicializa dos variables de tipo entero y realiza las cuatro operaciones aritméticas 
 * básicas (suma, resta, multiplicación, división) e imprime los resultados.
 */
public class Ejercicio11 {
	public static void main(String[] args) {
		int numeroUno = 10;
		int numeroDos = 20;
		// Una variable para almacenar el resultado
		double resultado = 0;
		
		// Generamos un array con las posibles operaciones
		char[] operaciones = {'+', '-', '*', '/'};
		
		// Utilizamos random para elegir una opción entre el array
		Random rand = new Random(); 
		
		// Definimos la operación a realizar
		char operacion = operaciones[rand.nextInt(4)];
		
		switch (operacion) {
		case '+' :
			resultado = numeroUno + numeroDos;
			break;
		case '-' :
			resultado = numeroUno - numeroDos;
			break;
		case '*' :
			resultado = numeroUno * numeroDos;
			break;
		case '/' :
			resultado = (double) numeroUno / numeroDos;
			break;
		default :
			System.out.println("No es una operación válida. ");
		}
		System.out.println("El resultado de realizar la operación " + numeroUno + " " + operacion + " " + numeroDos + " es: " + resultado);
		
	}
}
