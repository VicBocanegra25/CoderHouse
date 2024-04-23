package com.coderhouse.jerarquias;

import com.coderhouse.clases.Gato;
import com.coderhouse.clases.Perro;

public class Main {
	
	public static void main(String[] args) {
		Perro perro = new Perro(); 
		perro.setColor("Blanco");
		perro.setNombre("Coder");
		perro.setEdad(3);
		
		System.out.println("El perro " + perro.getNombre() + " es de color " + 
		perro.getColor() + " y tiene " + perro.getEdad() + " años de edad.");
		
		Gato gato = new Gato(); 
		gato.setColor("Rojo");
		gato.setNombre("Emil");
		gato.setEdad(2);
		
		System.out.println("El gato " + gato.getNombre() + " es de color " + 
		gato.getColor() + " y tiene " + gato.getEdad() + " años de edad.");
	}

}
