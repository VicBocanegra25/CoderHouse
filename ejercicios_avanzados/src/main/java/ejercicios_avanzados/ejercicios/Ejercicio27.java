package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.Cilindro;

/*
 * Define una subclase llamada Cilindro que herede de la clase Circulo y tenga un atributo 
 * adicional altura. Crea un objeto de tipo Cilindro e imprime su radio y altura.
 */
public class Ejercicio27 {
	public static void main(String[] args) {
		// Generamos un nuevo cilindro con radio y alturas aleatorios
		Random rand = new Random();
		Cilindro cilindroUno = new Cilindro(rand.nextDouble(100), rand.nextDouble(100));
		// Imprimimos los atributos
		System.out.println("El cilindroUno tiene una altura de: " + cilindroUno.getAltura() + ". Además, "
				+ "tiene un círculo de radio: " + cilindroUno.getRadio());
	}
}
