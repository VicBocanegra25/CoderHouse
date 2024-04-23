package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Animal;

/* 
 * Modifica la clase Animal para que el atributo nombre sea privado y 
 * proporciona métodos públicos para establecer y obtener este valor.
 */
public class Ejercicio39 {
	public static void main(String[] args) {
		// Instanciamos al animal (constructor sin argumentos)
		Animal unAnimal = new Animal();
		
		// Utilizamos el setter para darle un valor y lo imprimimos
		unAnimal.setNombre("Gato");
		
		System.out.println("El animal del que hablamos es un: " + unAnimal.getNombre());
	}
}
