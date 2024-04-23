package ejercicios_basicos;

import java.util.ArrayList;
import java.util.List;

/*
 * Declara una lista de cadenas de tamaño 3, inicialízala con nombres y luego imprime cada elemento
 *  de la lista en una línea separada.
 */
public class Ejercicio9 {
	// Declaramos una constante para mantener la lista con tamaño 3
	public final static int SIZE = 3; 
	
	public static void main(String[] args) {

		// Declaramos nuestra lista de cadenas como un ArrayList
		List<String> listaNombres = new ArrayList<>();
		
		// Inicializamos la lista con nombres (Intentamos con 4)
		agregarNombre(listaNombres, "Víctor");
		agregarNombre(listaNombres, "Eduardo");
		agregarNombre(listaNombres, "Teseo");
		agregarNombre(listaNombres, "Heracles");
		
		// Imprimimos el contenido de la lista con un for : each
		for (String nombre : listaNombres) {
			System.out.println(nombre);
		}
		
	}
	
	// Creamos una función auxiliar para agregar elementos a la lista (de modo que podamos controlar el tamaño)
	public static void agregarNombre(List<String> listaNombres_, String nombre_) {
		if (listaNombres_.size() < SIZE) {
			listaNombres_.add(nombre_);
			System.out.println("Se agregó el nombre '" + nombre_ + "' a la lista");
		} else {
			System.out.println("La lista sólo puede almacenar " + SIZE + " elementos.");
		}
	}
}
