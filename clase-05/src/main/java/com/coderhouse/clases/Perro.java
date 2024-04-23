package com.coderhouse.clases;

import java.util.Objects;

public class Perro extends Animal {

	private String raza;
	private String color; 
	private String nombre;
	
	
	
	public String getRaza() {
		return raza;
	}



	public void setRaza(String raza) {
		this.raza = raza;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", color=" + color + ", nombre=" + nombre + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perro other = (Perro) obj;
		return Objects.equals(color, other.color) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(raza, other.raza);
	}

	// Generated constructor from fields
	public Perro(String clase, boolean extinto, Integer edad, String genero, String raza, String color, String nombre) {
		super(clase, extinto, edad, genero);
		this.raza = raza;
		this.color = color;
		this.nombre = nombre;
	}



	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	} 

	// Métodos propios del perro
	public void ladrar () {
		System.out.println("Guau, guau. ");
	}
	
	public void comer() {
		System.out.println("El perro está comiendo comida balanceada. ");
	}
}
