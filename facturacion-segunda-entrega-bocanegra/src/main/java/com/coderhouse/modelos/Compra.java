package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// La clase / entidad Comrpa nos ayudará a crear una tabla para almacenar las compras realizadas por nuestros usuarios. 
@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "compra_id")
	private Integer compraID;
	@Column(name = "fecha_compra")
	private LocalDate fechaCompra;
	@Column(name = "total")
	private BigDecimal total;
	
	// Relacionamos la tabla Compras con la tabla Clientes. El tipo de relación es ManyToOne (Un cliente realiza muchas compras)
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	// Relacionamos los detalles de compra
	@OneToMany(mappedBy = "compra")
	private List <DetalleDeCompra> detallesCompra;
	
	
	// Constructor
	public Compra() {
		
	}

	public Integer getCompraID() {
		return compraID;
	}

	public void setCompraID(Integer compraID) {
		this.compraID = compraID;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// El ID de compra diferenciaa un objeto de otro
	@Override
	public int hashCode() {
		return Objects.hash(compraID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(compraID, other.compraID);
	}
	
	
}
