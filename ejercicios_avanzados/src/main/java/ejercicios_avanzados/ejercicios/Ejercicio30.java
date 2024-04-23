package ejercicios_avanzados.ejercicios;

import java.util.Iterator;

/*
 * Escribe un programa que tome un número como entrada y calcule su raíz cuadrada.
 * Maneja la excepción en caso de que el número sea negativo e imprime un mensaje adecuado en caso de que ocurra esta situación.
 */
public class Ejercicio30 {
	public static void main(String[] args) {
		// Intentamos calcular raíces de 10 números aleatorios
		for (int i = 0; i < 10; i++) {
			try {
				// Determinamos al azar si es negativo o positivo
				int signo = Math.random() > 0.5 ? 1 : -1 ;
				double numAleatorio = Math.random() * 100;
				// E imprimimos el resultado
				double raiz = calcularRaizCuadrada(numAleatorio * signo);
				System.out.println("La raíz del número " + numAleatorio + " es " + raiz); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
	}
	
	// Método para calcular raíces cuadradas
	public static double calcularRaizCuadrada(double numero) throws Exception {
			if (numero < 0) {
				throw new IllegalArgumentException("No se puede calcular la raíz de un número negativo.");
			}
			return Math.sqrt(numero);
	}
}
