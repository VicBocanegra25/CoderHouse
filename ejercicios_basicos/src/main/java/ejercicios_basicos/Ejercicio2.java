package ejercicios_basicos;

import java.util.Random;

/* 
 * Escribe un programa que tome un número como entrada e imprima "Es positivo" si es mayor que 0, "Es negativo" 
 * si es menor que 0, y "Es cero" si es igual a 0.

 */
public class Ejercicio2 {

	public static void main(String[] args) {
		// Declaramos una variable para el número a evaluar y para almacenar el mensaje a imprimir
		int numeroEvaluado;
		String mensajeFinal;
		
		// Inicializamos el número de forma aleatoria y utilizando la librería random para determinar si es + o -
		Random random = new Random();
		// El número aleatorio estará entre 0 y 10
		numeroEvaluado = random.nextInt(11) * (random.nextBoolean() ? -1: 1);
		
		// Utilizamos el control de flujo para asignar un mensaje
		if (numeroEvaluado == 0) {
			mensajeFinal = "Es cero";
		} else if (numeroEvaluado < 0){
			mensajeFinal = "Es negativo";
		} else {
			mensajeFinal = "Es positivo";
		}
		
		// Imprimimos el mensaje
		System.out.println(mensajeFinal);
	}

}
