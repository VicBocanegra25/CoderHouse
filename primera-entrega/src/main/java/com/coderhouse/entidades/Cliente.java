package com.coderhouse.entidades;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

// La clase Cliente será una entidad principal para nuestro programa. Almacena información sobre un cliente en la plataforma de comercio

//Utilizando las anotaciones para hacer la relación entre la clase/entidad y la BD
@Entity
@Table(name="clientes")
public class Cliente {

	// Declaramos los atributos de la clase (Columnas o Campos-Persistentes)
	// Nuestra llave primaria será el ID del cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteID;
	@Column(name = "telefono")
	private long telefono;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Email
	@Column(name = "correo_electronico")
	private String correoElectronico;
	@Column(name = "direccion")
	private String direccion; 
	
	// Relacionamos con la tabla de Compras (OneToMany, un cliente puede hacer muchas compras)
	@OneToMany(mappedBy = "cliente")
	private List<Compra> compras;
	
	// Hacemos un constructor vacío 
	public Cliente() {
		
	}

	// Declaramos getters / setters
	public Integer getClienteID() {
		return clienteID;
	}

	public void setClienteID(Integer clienteID) {
		this.clienteID = clienteID;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// Definimos un equals() y hashCode(), el clienteID nos ayuda a diferenciar un cliente de otro
	@Override
	public int hashCode() {
		return Objects.hash(clienteID);
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
		return Objects.equals(clienteID, other.clienteID);
	}
	
	
	
	
}
