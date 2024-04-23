package ejercicios_basicos;


/* 
 * Declara una matriz (array bidimensional) de enteros de tamaño 3x3, inicialízala con valores 
 * y luego imprime cada elemento de la matriz en una línea separada.
 */

public class Ejercicio19 {

	public static void main(String[] args) {
		// Se define una matriz de 3x3
		int[][] matriz = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
	
		int[][] nuevaMatriz = llenarMatriz();
		
		// Recorremos la matriz
		for(int i = 0; i < 3; i++) {
			// Hacemos un nested loop para recorrer los elementos de cada fila
			for(int j = 0; j < 3; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
		
		System.out.println(nuevaMatriz);
		imprimirMatriz(nuevaMatriz);
	}
	
	public static int[][] llenarMatriz(){
		// El método llena la matriz de números aleatorios
		int [][] matrizAleatoria = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
			matrizAleatoria[i][j] = (int) (Math.random() * 10);
			}
		}
		return matrizAleatoria;
	}

	public static void imprimirMatriz(int [][] matriz_) {
		// Recorremos la matriz
		for(int i = 0; i < 3; i++) {
			// Hacemos un nested loop para recorrer los elementos de cada fila
			for(int j = 0; j < 3; j++) {
				System.out.print(matriz_[i][j]);
			}
			System.out.println("");
		}
		
	}
	

}
