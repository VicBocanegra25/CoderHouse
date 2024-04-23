package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Persona;

//Crea una clase Persona con atributos nombre y edad. Luego crea un objeto de tipo Persona e imprime sus atributos.

public class Ejercicio21 {

	public static void main(String[] args) {
		// Instanciamos una persona
		Persona primeraPersona = new Persona("Víctor", 29);
		Persona segundaPersona = new Persona("Hugo", 29);
		
		// Imprimimos los atributos
		System.out.println(primeraPersona);
		System.out.println(segundaPersona);

		// Intentamos modificar la edad de la primera y de la segunda persona
		try {
		primeraPersona.setEdad(30);
		System.out.println("La edad de la primera persona es: " + primeraPersona.getEdad());
		// Esto da un error
		segundaPersona.setEdad(-1);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

