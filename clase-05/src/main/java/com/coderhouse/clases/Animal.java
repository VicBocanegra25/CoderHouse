package com.coderhouse.clases;

public class Animal {

	// Definimos los atributos
	private String clase;
	private boolean extinto;
	private Integer edad;
	private String genero;
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public boolean isExtinto() {
		return extinto;
	}

	public void setExtinto(boolean extinto) {
		this.extinto = extinto;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	// Constructor generated from Fields
	public Animal(String clase, boolean extinto, Integer edad, String genero) {
		super();
		this.clase = clase;
		this.extinto = extinto;
		this.edad = edad;
		this.genero = genero;
	}

	// Constructor generated from superclass
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Definición de los métodos
	public void comer() {
		System.out.println("El animal está comiendo. ");
	}
	
	public void dormir() {
		
	}

	public void andar() {
		
	}
	
	@Override
	public String toString() {
		return "Animal [clase=" + clase + ", extinto=" + extinto + ", edad=" + edad + ", genero=" + genero + "]";
	}
}
