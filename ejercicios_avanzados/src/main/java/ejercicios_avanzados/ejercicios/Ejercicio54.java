package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Conversor;

/* 
 * Define una clase Conversor con un método convertirCadenaANumero() que tome una cadena como parámetro 
 * y la convierta a un número entero. Maneja la excepción en caso de que la cadena no sea un número válido.
 */
public class Ejercicio54 {

	public static void main(String[] args) {
		// Declaramos la cadena
		String cadenaAEvaluar = "1234";
		String otraCadena = "UnoDosTresCuatro";
		
		// Instanciamos el conversor
		Conversor conversor = new Conversor();
		try {
			int numero = conversor.convertirCadenaANumeo(cadenaAEvaluar);
			System.out.println("La cadena " + cadenaAEvaluar + " se ha convertido a un Integer");
			
			// Esto fallará
			int numeroDos = conversor.convertirCadenaANumeo(otraCadena);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}
}
