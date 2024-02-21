package com.coderhouse;

public class Operadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Se estudian los operadores aritméticos: +, -, *, /, %
		 */
		int x = 5;
		float y = 6;
		float suma = x + y;
		double resta = x - y;
		int multiplicacion = (int) (x * y); // Type casting an operation
		double multiplicacion2 = x * y; 
		float division = x / y; 
		float modulo = x % y; 
				
		System.out.println("El resultado de la operación es: " + suma);
		System.out.println("El resultado de la operación es: " + resta);
		System.out.println("El resultado de la operación es: " + multiplicacion);
		System.out.println("El resultado de la operación es: " + division);
		System.out.println("El resultado de la operación es: " + modulo);

		
		
	}

}
