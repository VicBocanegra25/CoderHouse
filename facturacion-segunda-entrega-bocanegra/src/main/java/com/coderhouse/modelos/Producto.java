package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	// Se agrega este atributo para contabilizar la existencia del producto en inventario
	@Column(name = "existencia")
	private Integer existencia;
	

	// Relacionamos los productos con los detalles de compra
	@OneToMany(mappedBy = "producto")
	private List<DetalleDeCompra> detalleCompra;
		
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
	
	
	
	
}
