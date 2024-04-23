package com.coderhouse.clases.sobrecarga;

public class Calculadora {
	
	// Métodos para sumar, restar, multiplicar y dividir
	public void sumar(Integer a, Integer b) {
		System.out.println("Suma " + (a + b));
	}
	
	public void restar(Integer a, Integer b) {
		System.out.println("Resta " + (a - b));

	}
	
	public void multiplicar(Integer a, Integer b) {
		System.out.println("Multiplicación " + (a * b));

	}
	
	public void dividir(Integer a, Integer b) {
		if (b == 0) {
			throw new ArithmeticException("No se puede dividir por cero.");
		}
		System.out.println("División " + (a / b));
	}
	
	// Realizando sobrecarga de métodos (Ahora se operan con tres elementos)
	public void sumar(Integer a, Integer b, Integer c) {
		System.out.println("Suma " + (a + b + c));
	}
	
	public void restar(Integer a, Integer b, Integer c) {
		System.out.println("Resta " + (a - b - c));

	}
	
	public void multiplicar(Integer a, Integer b, Integer c) {
		System.out.println("Multiplicación " + (a * b * c));

	}
	
	public void dividir(Integer a, Integer b, Integer c) {
		if (b == 0 || c == 0) {
			throw new ArithmeticException("No se puede dividir por cero.");
		}
		System.out.println("División " + (a / b / c));
	}
	
}
