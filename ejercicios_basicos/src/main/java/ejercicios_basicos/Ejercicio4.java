package ejercicios_basicos;

import java.util.Random;

/* 
 * Declara un array de enteros de tamaño 5, inicialízalo con valores y luego imprime cada elemento 
 * del array en una línea separada.


 */
public class Ejercicio4 {

	public static void main(String[] args) {
		// Declaramos un array de Enteros sin inicializar.
		int[] arrayEnteros = new int[5];
		
		// Inicializamos valores aleatorios utilizando la librería random
		Random rand = new Random();
		arrayEnteros[0] = rand.nextInt(); 
		arrayEnteros[1] = rand.nextInt(); 
		arrayEnteros[2] = rand.nextInt(); 
		arrayEnteros[3] = rand.nextInt(); 
		arrayEnteros[4] = rand.nextInt(); 
		
		// Imprimimos cada elemento utilizando un bucle for
		for (int i = 0; i < arrayEnteros.length; i ++) {
			System.out.println("El elemento en la posición [" + i + "] es: " + arrayEnteros[i]);
		}
		
		
		// Imprimimos utilizando un foreach
		System.out.println("\nNuestro array contiene los elementos: ");
		for (int elemento: arrayEnteros) {
			System.out.println(elemento);
		}
	}
}