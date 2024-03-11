package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.Coche;

/*
 * Crea una clase Coche con atributos marca, modelo y año. Implementa los métodos equals() 
 * y hashCode() para comparar dos coches por su marca, modelo y año.
 */
public class Ejercicio45 {
	public static void main(String[] args) {
		// Instanciamos dos coches, mismos atributos (utilizamos constructor y le enviamos los parámetros). 
		Coche cocheUno = new Coche("Ford", "Mustang", 1975);
		Coche cocheDos = new Coche("Ford", "Mustang", 1975);
		
		// Comparamos los autos
		CompararObjetos comparador = new CompararObjetos();
		comparador.compararObjetos(cocheUno, cocheDos);
		
	}
}
