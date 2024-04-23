package ejercicios_avanzados.clases;

// La clase Cilindro hereda de la clase Círculo, pero tiene un atributo adicional: Altura

public class Cilindro extends Circulo{
	// Declaramos los atributos
	private double altura;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	// Los constructores heredan de la clase Círculo
	public Cilindro() {
		super();
	}

	public Cilindro(double radio, double altura) {
		super(radio);
		this.altura = altura;
	}

	// Método para calcular el área, sobre-escrito
	@Override
	public double calcularArea() {
		// El método calcula y devuelve el área lateral del cilindro (longitud circunferencia * altura)
		return 2 * super.getPi() * super.getRadio() * getAltura();
	}
	
	
	
	
	
}
