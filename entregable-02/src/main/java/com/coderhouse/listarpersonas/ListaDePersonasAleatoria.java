package com.coderhouse.listarpersonas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Esta es una ampliación del entregable. Utiliza la clase Persona para generar una lista de Personas con nombres aleatorios.
 * Los nombres y los apellidos son elegidos de forma aleatoria y se puede elegir el número de personas que contendrá la lista.
 */
public class ListaDePersonasAleatoria {
	// Definimos dos constantes, una lista con nombres y otra con apellidos
	private static final String[] LISTA_NOMBRES = {
	    "Lucía", "Sofía", "María", "Martina", "Paula", "Valeria", "Daniela", "Alba",
	    "Julia", "Luis", "Lucas", "Hugo", "Martín", "Daniel", "Pablo", "Alejandro",
	    "Alvaro", "Adrián", "Mateo", "David", "Santiago", "Leo", "Erick", "Jesús",
	    "Karla", "Carla", "Emma", "Olivia", "Clara", "Carlos"
	};
	
	private static final String[] LISTA_APELLIDOS = {"García", "Rodríguez", "Fernández", "López", "Martínez", "Sánchez", "Pérez",
		    "González", "Díaz", "Moreno", "Jiménez", "Marín", "Rubio", "Ramírez", "Hernández",
		    "Blanco", "Romero", "Navarro", "Alonso", "Torres", "Nieto", "Castro", "Gutiérrez",
		    "Castillo", "Ortega", "Molina", "Dominguez", "Ramos", "Arias", "Vargas"};
	private int longitudLista;
	
	public int getLongitudLista() {
		return longitudLista;
	}
	
	// El setter verifica que la longitud de la lista ingresada es positiva
	public void setLongitudLista(int longitudLista) {
		try {
			if (longitudLista < 0) {
				throw new Exception("La longitud de la lista debe ser un número positivo. ");
			} else {
				this.longitudLista = longitudLista;
			}
		} catch (Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	public static String[] getListaNombres() {
		return LISTA_NOMBRES;
	}
	public static String[] getListaApellidos() {
		return LISTA_APELLIDOS;
	}

	// El constructor para inicializar la clase (no implementamos constructor con la longitud de la lista)
	public ListaDePersonasAleatoria() {
		super();
	} 
	
	// Método para generar una lista de Personas con nombres y apellidos aleatorios
	public List<Persona> generarListaDePersonasAleatorias() {
		// Declaramos una lista
		List<Persona> listaDePersonasAleatorias = new ArrayList<Persona>();	
		// Instanciamos un objeto random para poder elegir los nombres y apellidos al azar
		Random rand = new Random();
		
		// Utilizamos un ciclo for para construir las personas
		 for (int i = 0; i < getLongitudLista(); i++) {
			 
			// En cada iteración, generamos una persona nueva
			 Persona nuevaPersona = new Persona();
			 // Y le damos un nombre y apellido generados de forma aleatoria
			 nuevaPersona.setNombre(LISTA_NOMBRES[rand.nextInt(LISTA_NOMBRES.length)]);
			 nuevaPersona.setApellido(LISTA_APELLIDOS[rand.nextInt(LISTA_APELLIDOS.length)]);			 
			 listaDePersonasAleatorias.add(nuevaPersona);
		}
		
		return listaDePersonasAleatorias;
	}
	
	
	
	
	

}
