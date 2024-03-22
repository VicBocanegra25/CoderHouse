package com.coderhouse.clases;

import com.coderhouse.interfaces.SerVivo;

// La clase Persona implementa la interfaz 'SerVivo'
public class Persona implements SerVivo{
	
	private String nombre;
	private String nacionalidad;
	private Integer edad;
	private boolean vive;
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Persona(String nombre, String nacionalidad, Integer edad, boolean vive) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.vive = vive;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public boolean isVive() {
		return vive;
	}
	public void setVive(boolean vive) {
		this.vive = vive;
	}
	
	
	// Cuando una clase implementa una interface, está obligada a implementar los métodos de la interfaz
	@Override
	public void comer() {
		System.out.println(this.nombre + " está comiendo.");
		
	}
	@Override
	public void respirar() {
		System.out.println(getNombre() + " esta respirando.");		
	}
	@Override
	public void moverse() {
		System.out.println(this.nombre + " se esta moviendo.");
		
	}
	@Override
	public void comunicarse() {
		System.out.println(this.nombre + " se esta comunicando.");
		
	}
	@Override
	public boolean estaVivo() {
		return isVive();
	}
	
	// Implementación propia del método 
	public void imprimirMensaje() {
		if(isVive()) {
			System.out.println(this.nombre + " esta con vida.");
		} else {
			System.out.println(this.nombre + " esta muerto lamentablemente.");
		}
	}
	

}
