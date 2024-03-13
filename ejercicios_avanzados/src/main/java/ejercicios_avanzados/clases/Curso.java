package ejercicios_avanzados.clases;

import java.util.Objects;

// Clase correspondiente al ejercicio 50. 

public class Curso {
	private String nombre;
	private String profesor;
	private String horario;
	
	// Getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	// Constructores
	public Curso(String nombre, String profesor, String horario) {
		super();
		this.nombre = nombre;
		this.profesor = profesor;
		this.horario = horario;
	}
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Dos cursos son iguales si los imparte el mismo profesor y tienen el mismo nombre
	@Override
	public int hashCode() {
		return Objects.hash(nombre, profesor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(profesor, other.profesor);
	}
	
	
	
}
