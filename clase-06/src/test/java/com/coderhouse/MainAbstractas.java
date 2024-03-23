package com.coderhouse;

import com.coderhouse.clasesabstractas.Circulo;
import com.coderhouse.clasesabstractas.Rectangulo;

public class MainAbstractas {

	public static void main(String[] args) {
		// Instanciamos las clases que heredan de clases abstractas
		Rectangulo rectangulo = new Rectangulo(6d, 5d);
		rectangulo.calcularArea();
		rectangulo.calcularPerimetro();
		
		// Instanciamos el círculo
		Circulo circulo = new Circulo(15d);
		circulo.calcularLongitudDeCircunferencia();
		circulo.calcularArea(); 
		
	}
}
