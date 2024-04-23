package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Estudiante;

/* 
 * Crea una subclase llamada Estudiante que herede de la clase Persona y 
 * tenga un atributo adicional grado. Luego crea un objeto de tipo Estudiante e imprime sus atributos.
 */
public class Ejercicio22 {
	public static void main(String[] args) {
		// Generamos un Estudiante 
		Estudiante primerEstudiante = new Estudiante("Víctor", 29, "Ninguno");
		
		// Imprimimos los atributos
		System.out.println(primerEstudiante);
		
		// Intentamos cambiar el grado
		try {
		primerEstudiante.setGrado("Licenciatura");
		System.out.println("El nuevo grado del estudiante es: " + primerEstudiante.getGrado());
		// Esto dará un error
		primerEstudiante.setGrado("Ninguno");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
