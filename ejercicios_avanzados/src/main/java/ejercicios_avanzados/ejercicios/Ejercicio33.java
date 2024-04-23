package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.Cuadrado;
import ejercicios_avanzados.clases.Rectangulo;

public class Ejercicio33 {
	public static void main(String[] args) {
		// Instanciamos un rectángulo con base y altura aleatorios
		Random rand = new Random(); 
		Rectangulo unRectangulo = new Rectangulo(rand.nextDouble(10), rand.nextDouble(10));
		// Imprimimos los atributos y utilizamos el método para calcular el perímetro
		System.out.println(unRectangulo);
		System.out.println("El perímetro del rectángulo es: " + unRectangulo.calcularPerimetro());

		// Instanciamos el cuadrado con lados aleatorios, imprimos atributos y utilizamos el método del perímetro
		Cuadrado unCuadrado = new Cuadrado();
		unCuadrado.setAncho(rand.nextDouble(10));
		System.out.println(unCuadrado);
		System.out.println("El perímetro del cuadrado es: " + unCuadrado.calcularPerimetro());
		
		
	}

}
