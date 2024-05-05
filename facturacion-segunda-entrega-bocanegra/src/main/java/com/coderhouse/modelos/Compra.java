package com.coderhouse.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

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
	@Column(name = "total_productos")
	private Integer totalProductos;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@JsonBackReference
	private Cliente cliente;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("compra-comprobante")
	private List<Comprobante> comprobantes;

	
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

	// Getters y setters de los elementos foráneos
	public List<Comprobante> getComprobantes() {
		return comprobantes;
	}

	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}

	public Integer getTotalProductos() {
		return totalProductos;
	}

	public void setTotalProductos(Integer totalProductos) {
		this.totalProductos = totalProductos;
	}
}
