package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

// Esta clase / entidad nos permite ligar las compras, productos y clientes
@Schema(description = "Esta entidad representa un comprobante de compra en la plataforma de comercio")
@Entity
@Table(name="comprobantes")
public class Comprobante {
	// Atributos de la clase
	@Schema(description = "El ID del comprobante", requiredMode = Schema.RequiredMode.AUTO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comprobante_id")
	private Integer comprobanteID;
	@Schema(description = "La cantidad de productos comprados", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
	@Column(name = "cantidad")
	private Integer cantidad;
	@Schema(description = "El producto comprado", requiredMode = Schema.RequiredMode.REQUIRED)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	@JsonBackReference("producto-comprobante")  // Named to match with Product's managed reference
	private Producto producto;

	@Schema(description = "La compra asociada al comprobante", requiredMode = Schema.RequiredMode.REQUIRED)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compra_id")
	@JsonBackReference("compra-comprobante")  // Named to match with Compra's managed reference
	private Compra compra;
	@Schema(description = "El precio del producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "15000.00")
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
		return Objects.hash(cantidad, compra, comprobanteID, precio, producto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprobante other = (Comprobante) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(compra, other.compra)
				&& Objects.equals(comprobanteID, other.comprobanteID) && Objects.equals(precio, other.precio)
				&& Objects.equals(producto, other.producto);
	}



	
}
