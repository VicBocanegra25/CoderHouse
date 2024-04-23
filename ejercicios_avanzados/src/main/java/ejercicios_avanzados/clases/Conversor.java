package ejercicios_avanzados.clases;

import java.util.Iterator;

// Esta clase corresponde al ejercicio 54
public class Conversor {

	public Conversor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int convertirCadenaANumeo(String cadenaNumeros) throws Exception {
		// Iterate over the characters of the String
		for (char item : cadenaNumeros.toCharArray()) {
			if (Character.isDigit(item) == false) {
				throw new Exception("No se puede convertir el valor ingresado (" + cadenaNumeros +"), pues contiene caracteres inválidos.");
			}
		} 
		
		return Integer.parseInt(cadenaNumeros);
	}

}
