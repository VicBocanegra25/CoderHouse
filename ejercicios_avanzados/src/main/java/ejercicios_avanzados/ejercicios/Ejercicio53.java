package ejercicios_avanzados.ejercicios;

import java.util.Random;

/* 
 * Crea una clase ListaNumeros con un método buscarNumero() que tome una lista de números y un 
 * número objetivo como parámetros y devuelva la posición del número objetivo en la lista. Maneja la 
 * excepción en caso de que el número objetivo no esté presente en la lista.
 */
public class Ejercicio53 {
	public static void main(String[] args) {
		// Instanciamos la lista de números y la llenamos de números aleatorios
		Random rand = new Random();
		ListaNumeros listaDeNumeros = new ListaNumeros();

		// Se agregaron 10 números aleatorios del 1 al 10
		for (int i = 0; i < 10; i++) {
			listaDeNumeros.getListaNumeros().add(rand.nextInt(10));
		}
		
		System.out.println(listaDeNumeros);
		
		// Busquemos el número 6 entre esta lista de números
		try {
			int posicion = listaDeNumeros.buscarNumero(listaDeNumeros.getListaNumeros(), 6);
			System.out.println("El número 6 se encuentra en la posición: " + posicion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			/* ListaNumeros [listaNumeros=[2, 7, 2, 0, 1, 5, 9, 5, 0, 4]]
			El número 6 no se encuentra en la lista. */
			
		}
		

		
	}
}
