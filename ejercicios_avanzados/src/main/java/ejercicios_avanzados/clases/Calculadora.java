package ejercicios_avanzados.clases;

// Clase correspondiente al ejercicio 51
public class Calculadora {

	public Calculadora() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double dividir(double numerador, double divisor) {
		if (divisor == 0) {
			throw new ArithmeticException("No se puede dividir por cero.");
		}
		return numerador/divisor;
	}
	
}
