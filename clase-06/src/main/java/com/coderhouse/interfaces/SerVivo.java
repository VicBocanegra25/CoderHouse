package com.coderhouse.interfaces;

// La interfaz SerVivo contiene todos los métodos que reutilizaremos en distintas clases
public interface SerVivo {
	
	// Estos métodos no tienen 'cuerpo', es decir, no tienen implementación
	void comer();
	void respirar();
	void moverse(); 
	void comunicarse(); 
	
	boolean estaVivo();
	
	

}
