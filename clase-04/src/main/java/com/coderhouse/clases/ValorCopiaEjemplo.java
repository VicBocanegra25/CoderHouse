package com.coderhouse.clases;

// Ejemplo de cómo Java pasa copias de las variables. 
public class ValorCopiaEjemplo {
	
	public static void main(String[] args) {
		// Declaramos una variable entera con un valor definido
		int x = 1;
		System.out.println("Valor original antes de invocar: " + x);
		imprimir(x);
		System.out.println("Valor original después de invocar " + x);
	}

	private static void imprimir(int x_) {
		System.out.println("Valor de la copia antes de ser modificada: " + x_);
		x_ = 12345;
		System.out.println("Valor de la copia después de ser modificad: " + x_);
	}
}
