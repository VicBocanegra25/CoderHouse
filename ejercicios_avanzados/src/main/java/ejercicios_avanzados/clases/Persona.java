package ejercicios_avanzados.clases;

// La clase persona corresponde al ejercicio 21.
public class Persona {
	// Definimos atributos de la clase
	private String nombre;
	private int edad;
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	// Colocamos restricciones a la edad (no puede ser negativa)
	public void setEdad(int edad) throws Exception {
		if (edad >= 0) {
		this.edad = edad;
		} else {
			throw new Exception("La edad no puede ser negativa. ");
		}
	}
	
	// Constructor con atributos
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	
	// Constructor sin atributos
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Método Override toString para imprimir los atributos
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	// Método para saludar
	public void saludar() {
		System.out.println("Hola, soy una persona.");
	}
	
	
}
