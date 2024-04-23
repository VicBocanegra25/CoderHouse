package ejercicios_avanzados.clases;

import java.util.Objects;

public class Alumno extends Persona {
	// Declaramos los atributos
	private String carrera;
	private String nombre =  super.getNombre();
	// Getters y setters para la carrera
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Alumno(String nombre, int edad, String carrera) {
		super(nombre, edad);
		this.carrera = carrera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(carrera, nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(carrera, other.carrera) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	
}
