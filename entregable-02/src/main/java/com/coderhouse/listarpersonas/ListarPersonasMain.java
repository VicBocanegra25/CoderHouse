package com.coderhouse.listarpersonas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Consigna: Deberán crear una segunda clase donde estará el método main como lo conocemos.
 * Creen 5 objetos: Personas con nombres y apellidos aleatorios, es importante que sean
 * nombres y apellidos en Español. 
 * Teniendo en cuenta los 5 objetos, agregarlos a una lista.
 * Crear la lógica para ordenar alfabéticamente la lista y mostrar en consola de acuerdo al
 * siguiente criterio: Ordenado por nombre. Ordenado por apellido. Ordenado inversamente por apellido.
 * BONUS: Se aumentó la funcionalidad al implementar un generador de nombres aleatorios (Véase la clase ListaDePersonasAleatoria)
 */
public class ListarPersonasMain {

	public static void main(String[] args) {
		
		// Instanciamos los objetos Persona
		Persona personaUno = new Persona("Jorge Luis", "Borges");  
		Persona personaDos = new Persona("Julio", "Cortázar");  
		Persona personaTres = new Persona("Federico", "Andahazi");  
		Persona personaCuatro = new Persona("Manuel", "Puig");  
		Persona personaCinco= new Persona("Juan", "Rulfo");
		
		// Creamos una lista tipo ArrayList
		List<Persona> listaDePersonas = new ArrayList<Persona>();
		
		// Agregamos las personas a esta lista
		listaDePersonas.add(personaUno);
		listaDePersonas.add(personaDos);
		listaDePersonas.add(personaTres);
		listaDePersonas.add(personaCuatro);
		listaDePersonas.add(personaCinco);
		
		// Llamamos las funciones para imprimir
		System.out.println("Imprimiendo la lista empezando por el nombre: ");
		ordenarPorNombre(listaDePersonas);
		System.out.println();
		
		System.out.println("Imprimiendo la lista empezando por apellido: ");
		ordenarPorApellido(listaDePersonas);
		System.out.println();
		
		System.out.println("Imprimiendo la lista empezando por apellido, pero en orden invertido: ");
		ordenarPorApellidoInverso(listaDePersonas);
		
		// Le cambiamos el nombre a una persona y volvemos a imprimir
		personaCinco.setNombre("Nepomuceno");
		personaCinco.setApellido("Vizcaíno");
		
		System.out.println();
		System.out.println("Imprimiendo la lista de nuevo, empezando por Nombre: ");
		ordenarPorNombre(listaDePersonas);
		
		// BONUS: Utilizamos la clase ListaDePersonasAleatoria para generar una lista con 100 nombres
		ListaDePersonasAleatoria nuevaListaDePersonas = new ListaDePersonasAleatoria();
		nuevaListaDePersonas.setLongitudLista(100);
		// Llamamos el método para generar la lista
		List<Persona> listaDePersonasAleatorias = new ArrayList<Persona>();
		listaDePersonasAleatorias = nuevaListaDePersonas.generarListaDePersonasAleatorias();
		
		// Imprimos la lista ordenada por nombres.
		System.out.println();
		System.out.println("Imprimimos una lista de " + nuevaListaDePersonas.getLongitudLista() + " personas cuyos nombres"
				+ " fueron generados de forma aleatoria.");
		ordenarPorNombre(listaDePersonasAleatorias);
		
	}
	
	// MÉTODOS AUXILIARES
	// Utilizaremos funciones para ordenar e imprimir la lista de personas
	public static void ordenarPorNombre(List<Persona> listaDePersonas_) {
		// Los array cuentan con el método sort() que podemos combinar con un Comparator()
		listaDePersonas_.sort(Comparator.comparing(Persona::getNombre));
		imprimirLista(listaDePersonas_, "nombre");		
	}
	
	public static void ordenarPorApellido(List<Persona> listaDePersonas_) {
		// Los array cuentan con el método sort() que podemos combinar con un Comparator()
		listaDePersonas_.sort(Comparator.comparing(Persona::getApellido));
		imprimirLista(listaDePersonas_, "apellido");		
	}
	
	public static void ordenarPorApellidoInverso(List<Persona> listaDePersonas_) {
		// Los array cuentan con el método sort() que podemos combinar con un Comparator() y el método reversed()
		listaDePersonas_.sort(Comparator.comparing(Persona::getApellido).reversed());
		imprimirLista(listaDePersonas_, "apellido");		
	}
	
	
	// Generamos una función auxiliar para imprimir el contenido de un array
	public static void imprimirLista(List<Persona> listaDePersonas_, String criterio) {
		
		for (Persona persona : listaDePersonas_) {
			// Se imprime primero el nombre y luego el apellido
			if (criterio == "nombre") {
				System.out.println(persona.getNombre() + " " + persona.getApellido());
			}
			// En este caso, comenzamos por el apellido, seguido del nombre
			else if (criterio == "apellido") {
				System.out.println(persona.getApellido() + " " + persona.getNombre());	
			} 
			else {
				System.out.println("Criterio inválido. Sólo se aceptan las opciones: 'nombre' y 'apellido'. ");
			}
		}
	}

	
}
