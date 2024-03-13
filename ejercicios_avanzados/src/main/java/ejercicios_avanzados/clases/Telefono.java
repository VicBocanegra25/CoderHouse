package ejercicios_avanzados.clases;

import java.util.Objects;

// Clase correspondiente al ejercicio 48

public class Telefono {
	// Atributos 
	private String marca;
	private String modelo;
	private long numero;
	
	// Getters y Setters
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
	// Constructores
	public Telefono(String marca, String modelo, long numero) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.numero = numero;
	}
	public Telefono() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Equals y HashCode. Dos teléfonos son iguales si tienen el mismo número
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return numero == other.numero;
	}
	
	
	
}
