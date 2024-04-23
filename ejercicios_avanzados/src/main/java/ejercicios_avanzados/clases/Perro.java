package ejercicios_avanzados.clases;

// Clase Perro que hereda de la clase Animal. Corresponde al ejercicio 37

public class Perro extends Animal {
	private String raza;
	
	// Getters y setters para el atributo raza.
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	// Agregamos un constructor vacío y uno que utiliza nombre y raza como parámetros
	public Perro(String nombre, String raza) {
		super(nombre);
		this.raza = raza;
	}

	public Perro() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + super.getNombre() + " raza=" + raza +  "]";
	}

	// Sobre-escribimos el método para emitir sonido.
	public void emitirSonido() {
		super.emitirSonido("El perro emite el ladrido: ¡Guau!");
	}

	
}
