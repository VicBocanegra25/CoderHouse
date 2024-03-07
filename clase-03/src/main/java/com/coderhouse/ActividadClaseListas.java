package com.coderhouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
 * Generar un programa que cree una lista, se complete con 10 números aleatorios y la recorra hasta el final,
 * o hasta que encuentre un múltiplo de 3. 
 */
public class ActividadClaseListas {
	public static void main(String[] args) {
		// Declaramos una lista del tipo ArrayList y la llenamos con 10 números aleatorios (utilizamos un for para llenar la lista)
		List<Integer> listaNumerosAleatorios = new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			// Agregamos los números de forma aleatorio (del 0 al 100)
			listaNumerosAleatorios.add(rand.nextInt(100));
		}
		
		// Generamos un iterator de la lista de números
		Iterator<Integer> iterator = listaNumerosAleatorios.iterator();

		// Recorremos la lista utilizando un bucle forEach e imprimimos
		listaNumerosAleatorios.forEach(number -> {
			System.out.println(number);
		}); 
		
		
	}
}
