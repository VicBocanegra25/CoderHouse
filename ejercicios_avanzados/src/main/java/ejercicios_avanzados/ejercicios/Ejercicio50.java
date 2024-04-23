package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.Curso;

/*
 * Define una clase Curso con atributos nombre, profesor y horario. 
 * Implementa los métodos equals() y hashCode() para comparar dos cursos por su nombre y profesor.
 */
public class Ejercicio50 {
	public static void main(String[] args) {
		// Instanciamos los cursos
		Curso cursoUno = new Curso("Programación Avanzada", "Alejandro Di Stefano", "Martes y Jueves");
		Curso cursoDos = new Curso("Bases de Datos", "Alejandro Di Stefano", "Lunes y Viernes");
		Curso cursoTres = new Curso("Programación Avanzada", "Alejandro Di Stefano", "Miércoles y Jueves");

		// Comparamos
		CompararObjetos comparador = new CompararObjetos();
		
		// El curso uno y tres tienen nombre y profesor iguales, por lo que hay igualdad
		comparador.compararObjetos(cursoUno, cursoDos);
		comparador.compararObjetos(cursoUno, cursoTres); // Iguales
		comparador.compararObjetos(cursoDos, cursoTres);
		
	}
}
