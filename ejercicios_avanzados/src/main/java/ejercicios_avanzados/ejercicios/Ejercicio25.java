package ejercicios_avanzados.ejercicios;

import java.util.Random;

/* 
 * Escribe un programa que tome dos números como entrada y realice una división. 
 * Maneja la excepción en caso de que el segundo número sea cero e imprime un mensaje 
 * adecuado en caso de que ocurra esta situación.

 */
public class Ejercicio25 {
	public static void main(String[] args) {
		Random rand = new Random();
		// Con un ciclo for, imprimimos varias veces, esperando a que el divisor sea 0 en algún momento
		for (int i = 0; i < 500; i++) {
			// Declaramos los números como dobles
			double numeroUno = rand.nextInt(10) ;
			double numeroDos = rand.nextInt(10) ; 
			// Llamamos el método
			dividir(numeroUno, numeroDos);
		}

	}
	
	public static void dividir(double numerador, double divisor) {
		try {
			if (divisor == 0.0){
				throw new Exception("No se puede dividir por cero");
			} else {
				System.out.println(numerador / divisor);
			}
		} catch (Exception e){
			System.err.println(e.getMessage());
		}
	}
}
