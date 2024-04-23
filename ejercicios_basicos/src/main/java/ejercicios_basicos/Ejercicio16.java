package ejercicios_basicos;

/* 
 * Declara una variable de tipo boolean y asígnale el resultado de comparar dos 
 * números enteros. Luego imprime el valor de la variable booleana.
 */
public class Ejercicio16 {

	public static void main(String[] args) {
		// Declaramos una variable booleana y dos enteros tomados de forma aleatoria
		int numeroUno = (int) (Math.random() * 10);
		int numeroDos = (int) (Math.random() * 10);
		// Utilizamos el operador ternario
		boolean elPrimeroEsMayor = numeroUno > numeroDos ? true : false;
		
		if(elPrimeroEsMayor) {
			System.out.println("El numeroUno es mayor que el numeroDos: " + elPrimeroEsMayor);
		} else {
			System.out.println("El numeroUno es mayor que el numeroDos: " + elPrimeroEsMayor);
		}
	}
}
