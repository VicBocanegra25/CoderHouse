package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.Ciudad;

/* 
 * Crea una clase Ciudad con atributos nombre y codigoPostal. Implementa los métodos equals() y hashCode() 
 * para comparar dos ciudades por su código postal.
 */
public class Ejercicio49 {
	public static void main(String[] args) {
		// Instanciamos ciudades
		// La actual ciudad de México cambió de nombre, antes se llamaba "Distrito Federal"
		Ciudad ciudadUno = new Ciudad("Distrito Federal", 03400);
		Ciudad ciudadDos = new Ciudad("Ciudad de México", 03400);
		// Brasil tiene una ciudad llamada Distrito Federal
		Ciudad ciudadTres = new Ciudad("Distrito Federal", 70040);
		
		// Comparamos
		CompararObjetos comparador = new CompararObjetos();
		
		// Diferente nombre, mismo CP
		comparador.compararObjetos(ciudadUno, ciudadDos);
		
		// Mismo nombre, distinto CP
		comparador.compararObjetos(ciudadUno, ciudadTres);
		
		// Nombre y CP Diferentes
		comparador.compararObjetos(ciudadDos, ciudadTres);
		
	}

}
