package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Animal;
import ejercicios_avanzados.clases.Perro;

/* 
 * Agrega un método emitirSonido() en la clase Animal que imprima un sonido genérico. 
 * Luego, sobrescribe este método en la clase Perro para que imprima "¡Guau!".
 */
public class Ejercicio38 {
	public static void main(String[] args) {
		// Instanciamos un Animal y un Perro
		Animal unAnimal = new Animal();
		Perro unPerro = new Perro();
		
		// Llamamos los métodos emitirSonido() 
		unAnimal.emitirSonido("Grrr");
		unPerro.emitirSonido();
		
	}
}
