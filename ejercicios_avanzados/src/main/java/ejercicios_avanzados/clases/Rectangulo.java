package ejercicios_avanzados.clases;

// Clase correspondiente al Ejercicio 31

public class Rectangulo {

	private double longitud;
	private double ancho;
	
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public Rectangulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rectangulo(double longitud, double ancho) {
		super();
		this.longitud = longitud;
		this.ancho = ancho;
	}
	
	// Un método to string para facilitar la impresión de atributos. 
	@Override
	public String toString() {
		return "Los atributos de la figura son: [longitud=" + longitud + ", ancho=" + ancho + "]";
	}
	
	// Método para calcular el perímetro (2*longitud + 2*ancho)
	public double calcularPerimetro() {
		return 2 * getAncho() + 2 * getLongitud();
	}
}
