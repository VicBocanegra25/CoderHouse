package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Circulo;

// Crea una clase Circulo con un atributo radio. Luego, crea un objeto de tipo Circulo e imprime su radio.


public class Ejercicio26 {
	public static void main(String[] args) {
		// Generamos un objeto Círculo y obtenemos su radio con el getter
		Circulo circuloUno = new Circulo(30);
		System.out.println("El círculoUno tiene un radio de: " + circuloUno.getRadio());
	}

}
