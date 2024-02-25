package com.coderhouse;

public class ControlDeFlujos {

	public static void main(String[] args) {
		// Declaramos dos variables numéricas
		float nroA = 4; 
		float nroB = 1;
		
		// Declaramos un float para almacenar el resultado de una operación
		float operacion = nroA / nroB;
		
		// Declaramos una condición para evitar la división por 0
		// Aquí se revisa si el divisor es distinto de cero
		if (nroB > 0) {
			System.out.println("Operación con Nros Positivos = " + operacion);	
			
		} else if (nroB < 0) {
			// Si el divisor es negativo
			System.out.println("Operación con Nros Negativos = " + operacion);	
			
		} else {
			// Si el divisor sí es me
			System.out.println("No se puede dividir por cero.");	
		}
		

	}

}
