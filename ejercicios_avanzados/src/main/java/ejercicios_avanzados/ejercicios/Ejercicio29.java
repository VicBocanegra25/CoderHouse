package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Circulo;

/*
 * Modifica la clase Circulo para que el atributo radio sea privado y 
 * proporciona métodos públicos para establecer y obtener este valor.
 */
public class Ejercicio29 {

	public static void main(String[] args) {
		// Instanciamos el círculo
		Circulo unCirculo = new Circulo();
		
		// Utilizamos los getters y setters
		unCirculo.setRadio(Math.random() * 10);
		
		// E imprimimos el radio y el área
		System.out.println("El área del círculo de radio " + unCirculo.getRadio() 
		+ " es " + unCirculo.calcularArea());
		
	}
}
