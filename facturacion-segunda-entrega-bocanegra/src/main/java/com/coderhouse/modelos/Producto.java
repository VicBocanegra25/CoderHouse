package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

// La clase/entidad Producto nos servirá para guardar información sobre los productos de la tienda en línea.
@Schema(description = "Esta entidad representa un producto en la plataforma de comercio")
@Entity
@Table(name = "productos")
public class Producto {
	// Los atributos de la clase
	@Schema(description = "El ID del producto", requiredMode = Schema.RequiredMode.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Integer productoID;
	@Schema(description = "El nombre del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Laptop")
	@Column(name = "nombre_producto")
	private String nombreProducto;
	@Schema(description = "La descripción del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Laptop HP. 32GB RAM, 1TB de almacenamiento.")
	@Column(name = "descripcion")
	private String descripcion;
	@Schema(description = "El precio del producto en pesos", requiredMode = Schema.RequiredMode.REQUIRED, example = "15000.00")
	@Column(name = "precio")
	private BigDecimal precio;
	@Schema(description = "La marca del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "HP")
	@Column(name = "marca")
	private String marca;
	@Schema(description = "La existencia del producto en el Stock", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
	@Column(name = "existencia")
	private Integer existencia;
	@Schema(description = "Los comprobantes asociados al producto")
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
