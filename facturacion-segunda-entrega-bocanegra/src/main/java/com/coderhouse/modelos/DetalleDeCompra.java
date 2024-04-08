package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Esta clase / entidad nos permite ligar las compras, productos y clientes 
@Entity
@Table(name="detalles_compra")
public class DetalleDeCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detalle_id")
	private Integer detallesID;
	@Column(name = "cantidad")
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;
	@Column(name = "precio")
	private BigDecimal precio;
	

	public DetalleDeCompra() {
		
	}


	public Integer getDetallesID() {
		return detallesID;
	}


	public void setDetallesID(Integer detallesID) {
		this.detallesID = detallesID;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(detallesID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleDeCompra other = (DetalleDeCompra) obj;
		return Objects.equals(detallesID, other.detallesID);
	}
	
	
	
}
