package ejercicios_basicos;

/*
 * Crea un programa que declare e inicialice una variable de cada tipo básico de Java (int, double, char, boolean) 
 * e imprime su valor.
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		// Declaramos las variables
		int miEdad;
		double miEstatura;
		char miInicialNombre;
		char miInicialApellido;
		boolean esCasado;
		
		// Inicializando las variables
		miEdad = 29;
		miEstatura = 1.70;
		miInicialNombre = 'V';
		miInicialApellido = 'B';
		esCasado = false;
		
		// Imprimiendo los valores en un mensaje: 
		System.out.println("Yo tengo " + miEdad	+ "años. Mido " + miEstatura + "metros. Mis iniciales son: " 
		+ miInicialNombre +  miInicialApellido + ". ¿Soy casado? La respuesta es: " + esCasado);
		
 }
}
