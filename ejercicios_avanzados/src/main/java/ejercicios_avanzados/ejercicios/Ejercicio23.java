package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Estudiante;
import ejercicios_avanzados.clases.Persona;

/*
 * Define un método saludar() en la clase Persona que imprima "Hola, soy una persona". 
 * Luego, sobrescribe este método en la clase Estudiante para que imprima "Hola, soy un estudiante".
 */
public class Ejercicio23 {
	public static void main(String[] args) {
		// Generamos instancias de persona y de estudiante
		Persona primeraPersona = new Persona("Hugo", 29); 
		Estudiante primerEstudiante = new Estudiante("Víctor", 29, "Licenciatura");
		
		// Llamamos sus métodos saludar()
		primeraPersona.saludar();
		primerEstudiante.saludar(); 
		
		
		
			
	}

}
