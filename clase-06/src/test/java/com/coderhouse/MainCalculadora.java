package com.coderhouse;

import com.coderhouse.clases.sobrecarga.Calculadora;

public class MainCalculadora {

	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		
		calculadora.sumar(12, 52);
		calculadora.restar(100, 20);
		calculadora.multiplicar(5, 6);
		try {
		calculadora.dividir(10, 0);
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		calculadora.dividir(20	, 10);
		
		// Implementando la sobrecarga de métodos
		calculadora.sumar(10, 20, 30);
		calculadora.restar(100, 20, 30);
		calculadora.multiplicar(5, 6, 7);
		calculadora.dividir(20, 10, 2);
	}

}
