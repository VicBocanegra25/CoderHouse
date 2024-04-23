package ejercicios_basicos;

/* 
 * Crea una clase Rectangulo que tenga atributos ancho y alto. 
 * Agrega un método para calcular el área del rectángulo y otro método para calcular el perímetro.
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		// Dentro del método main, creamos un rectángulo y utilizamos los métodos
		Rectangulo miRectangulo = new Rectangulo();
		// Colocamos valores para la altura y anchura
		miRectangulo.setAlto(12);
		miRectangulo.setAncho(15);
		// Calculamos e imprimimos área y perímetro
		System.out.println("El área del rectángulo de " + miRectangulo.getAlto() + " unidades de altura y " + 
		miRectangulo.getAncho() + " unidades de anchura es: " + miRectangulo.calcularArea());
		
		System.out.println("El perímetro del rectángulo de " + miRectangulo.getAlto() + " unidades de altura y " + 
				miRectangulo.getAncho() + " unidades de anchura es: " + miRectangulo.calcularPerimetro());

	}

	

}

final class Rectangulo {
	// Declaramos los atributos como privados
	private double ancho;
	private double alto; 
	
	// Generamos los getters y setters
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getAlto() {
		return alto;
	}
	public void setAlto(double alto) {
		this.alto = alto;
	}
	
	// Generamos los métodos para calcular área y perímetro
	public double calcularArea() {
		return this.alto * this.ancho;
	}
	
	public double calcularPerimetro() {
		return (2 * this.alto) + (2 * this.ancho);
	}
	
	
}
