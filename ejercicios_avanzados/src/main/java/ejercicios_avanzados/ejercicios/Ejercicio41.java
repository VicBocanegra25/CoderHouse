package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Libro;

/*
 * Crea una clase Libro con atributos titulo, autor y isbn. 
 * Implementa los métodos equals() y hashCode() para comparar dos libros por su ISBN.
 */
public class Ejercicio41 {
	public static void main(String[] args) {
		// Instanciamos dos libros.
		Libro libroUno = new Libro();
		Libro libroDos = new Libro(); 
		
		// Les damos atributos (título y autor distintos, mismo ISBN)
		libroUno.setTitulo("La insoportable levedad del ser");
		libroUno.setAutor("Milan Kundera");
		libroUno.setISBN(9786074213485l);

		libroDos.setTitulo("La insoportable");
		libroDos.setAutor("Milan K");
		libroDos.setISBN(9786074213485l);
		
		// Comparamos los objetos (y agregamos control de flujo)
		if (libroUno.equals(libroDos)) {
			System.out.println("Los libros son iguales"); // -> Con el mismo ISBN, se imprime este mensaje.
		} else {
			System.out.println("Los libros son distintos");
		}
	}
}
