package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Animal;

/*
  * Crea una clase Animal con un atributo nombre. Luego, crea un objeto de tipo 
  * Animal e imprime su nombre.
  */
public class Ejercicio36 {
	public static void main(String[] args) {
		// Instanciamos el objeto Animal, utilizamos el constructor con el nombre como argumento
		Animal unAnimal = new Animal("León");
		System.out.println("El nombre del animal es: " + unAnimal.getNombre());
	}
}
