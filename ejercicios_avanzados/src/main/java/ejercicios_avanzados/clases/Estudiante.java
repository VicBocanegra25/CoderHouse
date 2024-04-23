package ejercicios_avanzados.clases;

import java.util.Arrays;

public class Estudiante extends Persona {
	// La clase Estudiante tiene un atributo extra: grado
	private String grado;
	private static final String[] GRADOS = {
			"Licenciatura",
			"Maestría",
			"Doctorado",
			"Sin estudios de grado"
	};

	// Función auxiliar para imprimir los grados posibles
	public static void imprimirGrados() {
		for(String grado : GRADOS) {
			System.out.println(grado);
		}
	}
	// Getters y setters
	public String getGrado() {
		return grado;
	}
	
	// Restringimos el setter, sólo se puede colocar un valor existente en la constante GRADOS
	public void setGrado(String grado) throws Exception {
		// Si la constante contiene el grado, se peude asignar
		if (Arrays.asList(GRADOS).contains(grado)) {
			this.grado = grado;
		} else {
			imprimirGrados();
			throw new Exception("Esta opción no se encuentra en la lista. Intenta alguna de las anteriores. " );
			
		}
	}
	
	// Finalmente el constructor que extiende de la clase Persona
	public Estudiante(String nombre, int edad, String grado) {
		super(nombre, edad);
		this.grado = grado;
	}
	
	// Y un método toString para imprimir los atributos del estudiante
	@Override
	public String toString() {
		return "[El estudiante" + super.toString() + " sgrado=" + grado + "]";
	}
	
	
	// Método para saludar
	@Override
	public void saludar() {
		System.out.println("Hola, mi nombre es " + getNombre() + " y soy un estudiante.");
	}
	
	
}
