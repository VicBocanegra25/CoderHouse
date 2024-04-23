package ejercicios_avanzados.clases;

import ejercicios_avanzados.interfaces.Figura;

// Clase Circulo con atributo radio para el Ejercicio 26
public class Circulo implements Figura{
	// Declaramos atributos
	private double radio;
	private static final double PI = Math.PI; 

	// Getters y Setters
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public static double getPi() {
		return PI;
	}

	// Generamos dos constructores (uno vacío y uno con el radio).
	public Circulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}
	
	// Método para calcular el área de acuerdo con el ejercicio 28
	public double calcularArea() {
		return PI * Math.pow(getRadio(), 2);
	}
	

}
