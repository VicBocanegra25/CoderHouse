package ejercicios_avanzados.ejercicios;

import java.util.Scanner;

/* 
 * Escribe un programa que tome dos números como entrada y calcule su división. 
 * Maneja la excepción en caso de que el segundo número sea cero e imprime un 
 * mensaje adecuado en caso de que ocurra esta situación.
 */
public class Ejercicio35 {
	public static void main(String[] args) {
		// Utilizamos un objeto scanner para solicitar input al usuario.
		Scanner scan = new Scanner(System.in);
		System.out.println("Este programa permite calcular el resultado de la división de dos números. ");
		System.out.print("Ingresa el numerador: ");
		double numerador = scan.nextDouble();
		
		System.out.print("Ingresa el divisor: ");
		double divisor = scan.nextDouble();
		try {
			System.out.println("El resultado de dividir " + numerador + " entre " + divisor + 
					" es " + dividir(numerador, divisor));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static double dividir(double numerador_, double divisor_) {
		if (divisor_ == 0) {
			throw new ArithmeticException("No se puede dividir por cero");
		}
		return numerador_/ divisor_;
	}

}
