package com.coderhouse.clasesabstractas;

// Con esta clase estudiamos las clases abstractas
public abstract class Forma {

	// Declaramos dos métodos abstractos sin implementación. 
	abstract void calcularArea();
	
	abstract void calcularPerimetro(); 
	
	// Est emétodo es común a las clases abstractas.
	public void informacion() {
		System.out.println("Soy una forma geométrica. ");
		
	}
}
