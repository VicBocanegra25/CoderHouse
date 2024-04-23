package ejercicios_basicos;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/* 
 * Crea una clase Circulo que tenga un atributo radio. 
 * Agrega un método para calcular el área del círculo y otro método para calcular la circunferencia.
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		// Instanciamos un círculo
		Circulo miCirculo = new Circulo();
		
		// Le asignamos un radio de 45
		miCirculo.setRadio(45);
		
		// Calculamos el área y circunferencia (hasta 4 decimales y los almacenamos en una variable
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.FLOOR);
		
		double areaCirculo = miCirculo.calcularArea();
		double circCirculo = miCirculo.calcularCircunferencia();
		
		System.out.println("El círculo de radio " + miCirculo.getRadio() + " tiene un área de : " + 
		df.format(areaCirculo) + " u^2 y una circunferencia de : " + df.format(circCirculo) + " unidades.");
	}

}

final class Circulo {
	
	// Declaramos atributos para el círculo (privados)
	private double radio;

	// Se generan los getters/setters
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	} 
	
	// Desarrollamos los métodos para calcular área y circunferencia
	public double calcularArea() {
		return Math.pow(this.radio, 2) * Math.PI;
	}
	
	public double calcularCircunferencia() {
		return Math.PI * 2 * this.radio;
	}
}
