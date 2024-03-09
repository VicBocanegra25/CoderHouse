package ejercicios_avanzados.clases;

// Clase Circulo con atributo radio para el Ejercicio 26
public class Circulo {
	// Declaramos atributos
	private double radio;

	// Getters y Setters
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	// Generamos dos constructores (uno vacío y uno con el radio).
	public Circulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circulo(double radio) {
		super();
		this.radio = radio;
	}
	
	
	

}
