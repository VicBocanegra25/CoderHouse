package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Persona;

/* 
 * Modifica la clase Persona para que los atributos nombre y edad sean 
 * privados y proporciona métodos públicos para establecer y obtener estos valores.
 */

public class Ejercicio24 {
	public static void main(String[] args) {
		// Se crea la clase persona y se utilizan los getters y setters
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombre("Víctor");
		try {
			nuevaPersona.setEdad(29);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Se imprimen los atributos utilizando los getters
		System.out.println("Mi nombre es " + nuevaPersona.getNombre() + " y tengo " + nuevaPersona.getEdad() + " años de edad.");
		
	}
}
