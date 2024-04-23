package com.coderhouse.clases;

public class Perro {
	// Variables de instancia
	int tamaño; 
	String nombre;
	String raza;
	
	// Métodos
	public void ladrar() {
		System.out.println("Wof wof!");
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public static void main(String[] args) {
		// Creamos el objeto, llenamos las variables y usamos los métodos
		Perro unPerro = new Perro();
		unPerro.setNombre("Bobby");
		unPerro.setRaza("Callejero");
		unPerro.setTamaño(2);
		
		System.out.println("El perro " + unPerro.getNombre() + " es un " + unPerro.getRaza() + " tiene un tamaño " + 
		unPerro.getTamaño());

		unPerro.ladrar();
	}
	
}
