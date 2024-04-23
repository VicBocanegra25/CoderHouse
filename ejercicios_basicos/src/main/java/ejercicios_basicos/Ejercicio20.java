package ejercicios_basicos;

// Crea una clase Cuadrado que tenga un atributo lado. Agrega un método para calcular el área del cuadrado.

public class Ejercicio20 {
	public static void main(String[] args) {
		// Instanciando el cuadrado
		Cuadrado cuadrado = new Cuadrado(15);
		double area = cuadrado.calcularArea();
		
		System.out.println("El área del cuadrado de lado " + cuadrado.getLado() + " es + " + area);
		
	}
}

final class Cuadrado {
	
	private double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) throws Exception {
		// El lado no puede ser negativo
		if (lado < 0) {
			throw new Exception("El lado no puede ser negativo.");
		} else {
			
		this.lado = lado;
		}
	}

	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}
	
	// Método para calcular el área
	public double calcularArea() {
		return Math.pow(this.lado, 2); 
	}
	
	
}