package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.Rectangulo;

/* 
 * Crea una clase Rectangulo con atributos longitud y ancho. 
 * Luego, crea un objeto de tipo Rectangulo e imprime su longitud y ancho.
 */
public class Ejercicio31 {
	public static void main(String[] args) {
		// Instanciamos el rectángulo y llamamos un método para imprimir su longitud y anchura
		Random rand = new Random(); 
		Rectangulo unRectangulo = new Rectangulo(rand.nextDouble(100), rand.nextDouble(100)); 
		// Impresión del rectángulo
		System.out.println(unRectangulo);
		
	}
}
