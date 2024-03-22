package com.coderhouse.clases;

import com.coderhouse.interfaces.SerVivo;

// Esta clase hereda de la clase Animal, pero además implementa la interfaz SerVivo
public class Perro extends Animal implements SerVivo {

	private String nombre; 
	private String raza; 
	private Integer edad;
	private boolean vive;
	
	
	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perro(String clase) {
		super(clase);
		// TODO Auto-generated constructor stub
	}
	
	
	public Perro(String nombre, String raza, Integer edad, boolean vive) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.vive = vive;
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

	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respirar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comunicarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return isVive();
	}

}
