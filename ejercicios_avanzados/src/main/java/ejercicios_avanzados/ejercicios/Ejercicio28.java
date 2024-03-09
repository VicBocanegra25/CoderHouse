package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.Cilindro;
import ejercicios_avanzados.clases.Circulo;
import ejercicios_avanzados.interfaces.Figura;

/* 
 * Agrega un método calcularArea() en la clase Circulo que calcule y 
 * devuelva el área del círculo. Luego, sobrescribe este método en la clase 
 * Cilindro para calcular el área lateral del cilindro.
 */
public class Ejercicio28 {

	public static void main(String[] args) {
		// Instanciando un círculo y un cilindro
		Random rand = new Random();
		Circulo circuloUno = new Circulo(rand.nextDouble(100));
		Cilindro cilindroUno = new Cilindro(rand.nextDouble(100), rand.nextDouble(100));
		
		// Intentaremos crear un método que calcule e imprima las áreas de los objetos, sin declarar variables
		imprimirArea(circuloUno);
		imprimirArea(cilindroUno);
	}
	
	// Método auxiliar para imprimir el área de las figuras
	public static void imprimirArea(Figura figura) {
		System.out.println("El área de la figura es: " + figura.calcularArea());
	}
}
