package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Calculadora;

/* 
 * Crea una clase Calculadora con un método dividir() que tome dos números como parámetros y devuelva 
 * el resultado de la división. Asegúrate de manejar la excepción en caso de que el segundo número sea cero.
 */
public class Ejercicio51 {
	public static void main(String[] args) {
		// Instanciamos la calculadora
		Calculadora calculadora = new Calculadora();
		
		// Intentamos hacer la división con operadores váludos
		try {
			
			System.out.println("El resultado de la división es: " + calculadora.dividir(30d, 15d));
			// Ahora dividimos sobre 0
			System.out.println("El resultado de la división es: " + calculadora.dividir(5, 0));

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		
		// Y corregimos
		System.out.println("El resultado de la división es: " + calculadora.dividir(5, 4));
		
		// Y si el numerador es 0
		System.out.println("El resultado de la división es: " + calculadora.dividir(0, 4));
		
		
	}
}
