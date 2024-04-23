package com.coderhouse.clases;

import com.coderhouse.interfaces.SerVivo;

public class Pez extends Animal implements SerVivo{
	
	private String nombre; 
	private boolean vive;
	
	public Pez() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pez(String clase, String nombre, boolean vive) {
		super(clase);
		this.nombre = nombre;
		this.vive = vive;
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVive() {
		return vive;
	}
	public void setVive(boolean vive) {
		this.vive = vive;
	}
	
	

	@Override
	public void comer() {
		System.out.println(this.nombre + " come algas marinas. ");
		
	}
	@Override
	public void respirar() {
		// TODO Auto-generated method stub
		System.out.println(this.nombre + " respira a través de las branquias.");

	}
	@Override
	public void moverse() {
		// TODO Auto-generated method stub
		System.out.println(this.nombre + " está nadando.");
		
	}
	@Override
	public void comunicarse() {
		System.out.println(this.nombre + " no se comunica. ");
	}
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
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
