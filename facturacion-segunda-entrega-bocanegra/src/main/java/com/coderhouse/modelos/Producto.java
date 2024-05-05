package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

// La clase/entidad Producto nos servirá para guardar información sobre los productos de la tienda en línea. 
@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Integer productoID;
	@Column(name = "nombre_producto")
	private String nombreProducto;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private BigDecimal precio;
	@Column(name = "marca")
	private String marca;
	@Column(name = "existencia")
	private Integer existencia;

	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	@JsonManagedReference("producto-comprobante")
	private List<Comprobante> comprobante;

	// Constructor manual vacío
	public Producto() {
		
	}
	// Getters & Setters
	public Integer getProductoID() {
		return productoID;
	}

	public void setProductoID(Integer productoID) {
		this.productoID = productoID;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Integer getExistencia() {
		return existencia;
	}
	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}
	
	// El ID del producto lo hace distinto de otros productos
	@Override
	public int hashCode() {
		return Objects.hash(productoID);
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
		return Objects.equals(productoID, other.productoID);
	}

	// Getters y setters de los elementos foráneos
	public List<Comprobante> getComprobante() {
		return comprobante;
	}

	public void setComprobante(List<Comprobante> comprobante) {
		this.comprobante = comprobante;
	}
}
