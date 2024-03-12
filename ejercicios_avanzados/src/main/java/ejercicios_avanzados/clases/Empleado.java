package ejercicios_avanzados.clases;

import java.util.Objects;

// La clase Empleado corresponde al ejercicio 47
public class Empleado {
	
	// Atributos
	private String nombre;
	private String departamento;
	private double salario;
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// Constructores
	public Empleado(String nombre, String departamento, double salario) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
	}
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Hashcode y Equals, se consideran el nombre y departamento
	@Override
	public int hashCode() {
		return Objects.hash(departamento, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(nombre, other.nombre);
	}
	

	
	

}
