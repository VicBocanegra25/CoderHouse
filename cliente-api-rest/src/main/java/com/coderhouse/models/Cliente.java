package com.coderhouse.models;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

// Definimos esta clase como una entidad en nuestra db (será la tabla Clientes)
@Entity
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")	
	private String apellido;
	
	// Agregamos esta anotación para indicar que la fecha de nacimiento NO se muestra en el GET
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "fecha_de_nacimiento")
	private LocalDate fechaNacimiento; // Utilizamos esta clase para almacenar la fecha

	// Esta anotación indica que la variable no será almacenada en la bd
	@Transient
	private Integer edad; 
	
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// Declaramos el equals y hashCode, un cliente es distinto de otro gracias al id
	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
	
	@Transient
	// Probando con otros atributos
	private String ubicacion;

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}
