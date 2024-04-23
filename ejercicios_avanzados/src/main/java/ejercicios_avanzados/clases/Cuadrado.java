package ejercicios_avanzados.clases;

// Clase Cuadrado correspondiente al ejercicio 32. 
public class Cuadrado extends Rectangulo{
	// Un cuadrado tiene longitud y anchura, pero estos valores son iguales.
	
	
	
	public Cuadrado() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Cuando se llama a los setters, ambos valores guardan la longitud y la anchura. 
	@Override
	public void setLongitud(double longitud) {
		// TODO Auto-generated method stub
		super.setLongitud(longitud);
		super.setAncho(longitud);
	}

	@Override
	public void setAncho(double ancho) {
		// TODO Auto-generated method stub
		super.setAncho(ancho);
		super.setLongitud(ancho);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	// Método para calcular el perímetro (2*longitud + 2*ancho)
	public double calcularPerimetro() {
		return 4 * getLongitud();
	}
	
	
	

}
