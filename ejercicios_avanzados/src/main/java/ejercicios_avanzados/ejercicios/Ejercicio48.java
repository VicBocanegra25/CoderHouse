package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.Telefono;

/* 
 * Define una clase Telefono con atributos marca, modelo y numero. Implementa los métodos equals() 
 * y hashCode() para comparar dos teléfonos por su número.
 */
public class Ejercicio48 {
	public static void main(String[] args) {
		// Instanciamos tres teléfonos con el constructor que utiliza los parámetros
		Telefono telefonoUno = new Telefono("Samsung", "Galaxy S9", 5564748037l);
		Telefono telefonoDos = new Telefono("Samsung", "Galaxy S9", 5560708090l);
		Telefono telefonoTres = new Telefono("LG", "Prime", 5564748037l );

		// Comparamos los teléfonos. A pesar de que 1 y 3 son distinta marca y modelo, comparten el mismo número
		CompararObjetos comparador = new CompararObjetos();
		
		comparador.compararObjetos(telefonoUno, telefonoDos);
		// Al tener el mismo teléfono, 1 y 3 son iguales
		comparador.compararObjetos(telefonoUno, telefonoTres);
		comparador.compararObjetos(telefonoDos, telefonoTres);
		
		
	}
}
