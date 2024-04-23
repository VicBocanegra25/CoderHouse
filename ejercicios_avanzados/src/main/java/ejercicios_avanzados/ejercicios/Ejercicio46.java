package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.Alumno;

/* 
 * Define una clase Alumno con atributos nombre, edad y carrera. Implementa los métodos equals()
 * y hashCode() para comparar dos alumnos por su nombre y carrera.
 */
public class Ejercicio46 {

	public static void main(String[] args) {
		 // Instanciamos tres alumnos y los comparamos utilizando la clase auxiliar
		Alumno alumnoUno = new Alumno("Víctor", 29, "Sistemas Computacionales");
		Alumno alumnoDos = new Alumno("Hugo", 29, "Medicina");
		Alumno alumnoTres = new Alumno("Víctor", 29, "Sistemas Computacionales");
		CompararObjetos comparador = new CompararObjetos();
		
		// Llamamos el método para comparar los dos objetos de la clase Alumno
		comparador.compararObjetos(alumnoUno, alumnoDos);
		comparador.compararObjetos(alumnoUno, alumnoTres);

	}

}
