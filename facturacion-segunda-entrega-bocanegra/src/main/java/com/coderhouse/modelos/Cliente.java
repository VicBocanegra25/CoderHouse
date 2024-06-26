package com.coderhouse.modelos;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Esta entidad representa a un cliente en la plataforma de comercio")
@Entity
@Table(name="clientes")
public class Cliente {

	// Declaramos los atributos de la clase (Columnas o Campos-Persistentes)
	// Nuestra llave primaria será el ID del cliente
	@Schema(description = "El ID del cliente", requiredMode = Schema.RequiredMode.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Integer clienteID;
	@Schema(description = "El número de teléfono del cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED) // El teléfono es opcional
	@Column(name = "telefono")
	private long telefono;
	@Schema(description = "El nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Víctor")
	@Column(name = "nombre")
	private String nombre;
	@Schema(description = "El apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Bocanegra")
	@Column(name = "apellido")
	private String apellido;
	@Schema(description = "El correo electrónico del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "victor@coderhouse.com")
	@Email
	@Column(name = "correo_electronico")
	private String correoElectronico;
	@Schema(description = "La dirección del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Calle 233, CDMX")
	@Column(name = "direccion")
	private String direccion; 
	
	// Relacionamos con la tabla de Compras (OneToMany, un cliente puede hacer muchas compras)
	@Schema(description = "Las compras realizadas por el cliente")
	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference // Esta anotación previene el problema de la recursividad al realizar la serialización en las solicitudes
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

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	
	
	
}
