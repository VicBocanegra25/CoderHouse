package com.coderhouse.clasesabstractas;

// La clase que hereda de una clase abstracta debe implementar y sobre-escribir los métodos de la superclase
public class Rectangulo extends Forma {

	private Double base;
	private Double altura;	
	
	public Rectangulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Rectangulo(Double base, Double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}



	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public void calcularArea() {
		// TODO Auto-generated method stub
		System.out.println("El área del rectángulo es de: " + (getBase() * getAltura()));
	}

	@Override
	public void calcularPerimetro() {
		System.out.println("El perímetro del rectángulo es de: " + (2 * getBase() 
				+ 2 * getAltura()));
	}

}
