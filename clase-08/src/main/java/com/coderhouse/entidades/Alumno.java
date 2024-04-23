package com.coderhouse.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// La clase Alumno es una clase-entidad (es decir, una Tabla en la BD). 

// Utilizando las anotaciones para hacer la relación entre la clase/entidad y la BD
@Entity
@Table(name="alumnos")
public class Alumno {
	
	// Declaramos los atributos de la clase (las columnas o campos-persistentes)
	// El dni será nuestra Primary Key
	@Id
	@Column(name="dni")
	private Integer dni;
	// La anotación Column nos permite especificar el nombre para la columna
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="legajo")	
	private Integer legajo;
	
	// Relacionando las tablas Alumno y Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;
	@Column(name="id_curso", insertable = false, updatable = false)
	private Integer idCurso;
	
	// Constructor vacío
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	
	// Legajo es el único atributo considerado en el hashCode
	@Override
	public int hashCode() {
		return Objects.hash(legajo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(legajo, other.legajo);
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	} 
	
	
	
}
