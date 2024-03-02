package ejercicios_basicos;

// Escribe un programa que imprima los números del 1 al 10 utilizando un bucle for.


public class Ejercicio3 {

	public static void main(String[] args) {
		// Utilizamos un bucle for, con límite del 10 (colocamos 11, ya que el for excluye el 10)
		for (int i = 1; i < 11; i++) {
			// En cada iteración imprimimos el valor
			System.out.println("El número actual es: " + i);
		}
	}

}
