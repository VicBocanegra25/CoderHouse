package com.coderhouse.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coderhouse.modelos.DetalleDeCompra;
import com.coderhouser.repositorios.DetalleDeCompraRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DetalleCompraServicio {

	// El servicio se conecta directametne con el repositorio
	@Autowired
	private DetalleDeCompraRepositorio detalleDeCompraRepository; 
	
	// Declaramos métodos para realizar las operaciones CRUD en la base de datos
	public List<DetalleDeCompra> listarDetalleDeCompras() {
		return detalleDeCompraRepository.findAll();
	}
	
	public DetalleDeCompra listarDetalleDeCompraPorID(Integer detalleDeCompraId) {
		return detalleDeCompraRepository.findById(detalleDeCompraId).orElseThrow(() -> new EntityNotFoundException("No se encontró un detalleDeCompra con id " + detalleDeCompraId));
	}
	
	public DetalleDeCompra agregarDetalleDeCompra(DetalleDeCompra detalleDeCompraNuevo) {
		return detalleDeCompraRepository.save(detalleDeCompraNuevo);
	}
	
	public DetalleDeCompra editarDetalleDeCompraPorID(Integer detalleDeCompraId, DetalleDeCompra detalleDeCompraModificado) {
		try {
			if (detalleDeCompraRepository.existsById(detalleDeCompraId)) {
				detalleDeCompraModificado.setDetalleDeCompraID(detalleDeCompraId);
				return detalleDeCompraRepository.save(detalleDeCompraModificado);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el detalleDeCompra con id " + detalleDeCompraId);
		}
		return null;
	}
	
	public boolean eliminarDetalleDeCompraPorId(Integer detalleDeCompraId) {
		try {
			if (detalleDeCompraRepository.existsById(detalleDeCompraId)) {
				detalleDeCompraRepository.deleteById(detalleDeCompraId);
				return true;
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el detalleDeCompra con id " + detalleDeCompraId);
		}
		return false;
	}	
	
	
}
