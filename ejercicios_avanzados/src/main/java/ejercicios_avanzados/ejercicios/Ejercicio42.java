package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Persona;

/* 
 * Define una clase Persona con atributos nombre y edad. 
 * Implementa los métodos equals() y hashCode() para comparar dos personas 
 * por su nombre y edad.

 */
public class Ejercicio42 {
	public static void main(String[] args) throws Exception {
		// Instanciamos tres personas, dos con mismo nombre y edad, una distinta
		Persona personaUno = new Persona();
		Persona personaDos = new Persona();
		Persona personaTres = new Persona(); 
		
		personaUno.setNombre("Bruce Wayne"); personaUno.setEdad(30);
		personaDos.setNombre("Bruce Wayne"); personaDos.setEdad(30);
		personaTres.setNombre("Bruno Díaz"); personaTres.setEdad(30);

		// Llamamos la función para comparar personas
		compararPersonas(personaUno, personaDos); // -> True
		compararPersonas(personaDos, personaTres); // -> False
		compararPersonas(personaTres, personaUno); // -> False
	}
	
	// Método auxiliar que sirve para comparar dos objetos del tipo persona
	public static void compararPersonas(Persona personaUno_, Persona personaDos_) {
		if (personaUno_.equals(personaDos_)) {
			System.out.println("Las personas son iguales. ");
		} else {
			System.out.println("Las personas son distintas. ");
		}
	}
	
}
