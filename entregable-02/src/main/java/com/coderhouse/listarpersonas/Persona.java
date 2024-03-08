package com.coderhouse.listarpersonas;

/*
 * Consigna: Deberán crear la clase persona que tiene como atributos nombre y apellido, 
 * ambos de tipo String; la clase tiene sus métodos getters y setters para cada atributo
 */
public class Persona {

	// Se declaran los atributos
	private String nombre;
	private String apellido;
	
	// Se declaran los getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	// Declaramos un constructor vacío y otro a partir de los atributos
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	
	
}
