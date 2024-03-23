package com.coderhouse;

import com.coderhouse.clases.Perro;
import com.coderhouse.clases.Persona;
import com.coderhouse.clases.Pez;
import com.coderhouse.interfaces.SerVivo;

public class MainInterfaces {

	public static void main(String[] args) {
		// Instanciamos los objetos
		Perro unPerro = new Perro(); 
		unPerro.setVive(true);	
		unPerro.setNombre("Velkan");
		unPerro.setEdad(10);
		unPerro.setRaza("Husky");
		unPerro.setClase("Mamifero");
	
		System.out.println("Mi perro " + unPerro.getNombre() 
		+ ", es de la raza " + unPerro.getRaza()
		+ ", es del tipo " + unPerro.getClase()
		+ " y tiene " + unPerro.getEdad() + " años de edad.");
		
		// Imprimimos el método propio del perro.
		unPerro.imprimirMensaje();
		
		// Ahora métodos heredados de la interfaz
		realizarAccionesSiVive(unPerro);
		
		// Otra instancia de perro
		Perro otroPerro = new Perro("Mamífero", "Lacie", "Ovejero Alemán", 10, false);
		System.out.println("Mi perro " + otroPerro.getNombre() 
		+ ", es de la raza " + otroPerro.getRaza()
		+ ", es del tipo " + otroPerro.getClase()
		+ " y tiene " + otroPerro.getEdad() + " años de edad.");
		otroPerro.imprimirMensaje();
		realizarAccionesSiVive(otroPerro);
		
		// Ahora hacemos una instancia de la clase Persona
		Persona persona = new Persona("Víctor", "Mexicana", 29, true);
		System.out.println(persona.getNombre() + " es de " + persona.getNacionalidad()
		+ " y tiene " + persona.getEdad() + " de Edad.!");
		persona.imprimirMensaje();
		realizarAccionesSiVive(persona);
		
		// instancias de Pez
		Pez pez = new Pez("Ovíparo" , "Sebastián", true);
		System.out.println("\n Sebastián es un pescado. ");
		pez.imprimirMensaje();
		realizarAccionesSiVive(pez);
		
	}

	// Método auxiliar para verificar si se realizan las acciones si el atributo isVive = true
	public static void realizarAccionesSiVive(SerVivo serVivo) {
		if (serVivo.estaVivo()) {
			serVivo.comer();
			serVivo.comunicarse();
			serVivo.respirar();
			serVivo.moverse();
		}
	}
}
