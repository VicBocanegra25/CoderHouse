package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.Cuadrado;

/* 
 * Define una subclase llamada Cuadrado que herede de la clase Rectangulo. 
 * Crea un objeto de tipo Cuadrado e imprime su longitud y ancho.
 */

public class Ejercicio32 {
	public static void main(String[] args) {
		// Instanciamos un cuadrado
		Cuadrado unCuadrado = new Cuadrado();
		Random rand = new Random(); 
		
		// Le asignamos las dimensiones e imprimimos los atributos. 
		unCuadrado.setAncho(rand.nextDouble(10));
		System.out.println(unCuadrado);
		// Actualizamos las dimensiones y volvemos a imprimir para comprobar que los métodos funcionan
		unCuadrado.setLongitud(rand.nextDouble(10));
		System.out.println(unCuadrado);
	}
}
