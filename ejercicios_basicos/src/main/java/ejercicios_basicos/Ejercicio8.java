package ejercicios_basicos;

// Escribe un programa que imprima los números pares del 1 al 20 utilizando un bucle while.


public class Ejercicio8 {
	
	public static void main(String[] args) {
		// Declaramos una variable para llevar la cuenta
		int contador = 1;

		// Generamos el bucle while, con la condición de que se detenga hasta llegar al 20 (inclusivo)
		do {
			// Se evalúa si el número es par
			if (contador % 2 == 0) {
			System.out.println("Contador: " + contador);
				}
			// Se incrementa el contador
			contador++; 
			
			} while (contador < 21);
		}

}
