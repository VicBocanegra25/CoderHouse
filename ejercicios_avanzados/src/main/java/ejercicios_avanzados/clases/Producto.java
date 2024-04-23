package ejercicios_avanzados.clases;

import java.util.Objects;

// La clase Producto corresponde al ejercicio 43

public class Producto {
	private String nombreProducto;
	private double precio;
	private long codigo;
	
	// Implementamos los getters y setters. 
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	// Implementamos un constructor vacío
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo;
	}
	
	
	
}
