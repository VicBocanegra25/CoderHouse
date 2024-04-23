package ejercicios_basicos;

// Escribe un programa que imprima los números impares del 1 al 15 utilizando un bucle while.

public class Ejercicio18 {
	public static void main(String[] args) {
		// Definimos un contador para utilizar dentro del bucle while
		int contador = 0;
		
		while (contador <= 15) {
			if (contador % 2 != 0) {
				System.out.println(contador);
			}
			contador++;
		}
	}
}
