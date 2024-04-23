package com.coderhouse.clasesabstractas;

public class Circulo extends Forma {
	
	private Double radio;
	private final static Double PI = Math.PI;
	
	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}

	public static Double getPi() {
		return PI;
	}

	public Circulo(Double radio) {
		super();
		this.radio = radio;
	}

	public Circulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcularArea() {
		// TODO Auto-generated method stub
		System.out.println("El área del círculo es: " + 
		(PI * Math.pow(getRadio(), 2)));
	}

	@Override
	void calcularPerimetro() {
		// TODO Auto-generated method stub
		System.out.println("La longitud de la circunferencia del círculo es: " + 
		(2 * PI * getRadio()));

	}
	
	public void calcularLongitudDeCircunferencia() {
		calcularPerimetro();
	}

}
