package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.Rectangulo;

/* 
 * Modifica la clase Rectangulo para que los atributos longitud y ancho 
 * sean privados y proporciona métodos públicos para establecer y obtener estos valores.
 */
public class Ejercicio34 {

	public static void main(String[] args) {
		// Instanciamos un rectángulo utilizando el constructor sin atributos
		Random rand = new Random(); 
		Rectangulo unRectangulo = new Rectangulo();
		unRectangulo.setAncho(rand.nextDouble(10));
		unRectangulo.setLongitud(rand.nextDouble(10));
		
		// Imprimimos atributos
		System.out.println(unRectangulo);
	}
}
