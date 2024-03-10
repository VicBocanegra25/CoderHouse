package ejercicios_avanzados.clases;

// Clase Animal correspondiente al ejercicio 36

public class Animal {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Agregamos dos constructores (uno con parámetros y otro sin). 
	public Animal(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Método emitirSonido()
	public void emitirSonido(String sonidoGenerico) {
		System.out.println("El animal emite el sonido " + sonidoGenerico);
	}
	

}
