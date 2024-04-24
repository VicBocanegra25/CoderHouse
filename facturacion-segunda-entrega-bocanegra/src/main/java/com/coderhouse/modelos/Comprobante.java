package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name="comprobantes")
public class Comprobante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comprobante_id")
	private Integer comprobanteID;
	@Column(name = "cantidad")
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "compra_id")
	private Compra compra;

	@Column(name = "precio")
	private BigDecimal precio;

	public Comprobante() {
		
	}


	public Integer getComprobanteID() {
		return comprobanteID;
	}


	public void setComprobanteID(Integer comprobanteID) {
		this.comprobanteID = comprobanteID;
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
		return Objects.hash(comprobanteID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		comprobante other = (comprobante) obj;
		return Objects.equals(comprobanteID, other.comprobanteID);
	}
	
	
	
}
