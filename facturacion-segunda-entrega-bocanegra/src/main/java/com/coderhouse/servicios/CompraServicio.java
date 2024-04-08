package com.coderhouse.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coderhouse.modelos.Compra;
import com.coderhouser.repositorios.CompraRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompraServicio {

	// El servicio se conecta directametne con el repositorio
	@Autowired
	private CompraRepositorio compraRepository; 
	
	// Declaramos métodos para realizar las operaciones CRUD en la base de datos
	public List<Compra> listarCompras() {
		return compraRepository.findAll();
	}
	
	public Compra listarCompraPorID(Integer compraId) {
		return compraRepository.findById(compraId).orElseThrow(() -> new EntityNotFoundException("No se encontró un compra con id " + compraId));
	}
	
	public Compra agregarCompra(Compra compraNuevo) {
		return compraRepository.save(compraNuevo);
	}
	
	public Compra editarCompraPorID(Integer compraId, Compra compraModificado) {
		try {
			if (compraRepository.existsById(compraId)) {
				compraModificado.setCompraID(compraId);
				return compraRepository.save(compraModificado);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el compra con id " + compraId);
		}
		return null;
	}
	
	public boolean eliminarCompraPorId(Integer compraId) {
		try {
			if (compraRepository.existsById(compraId)) {
				compraRepository.deleteById(compraId);
				return true;
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el compra con id " + compraId);
		}
		return false;
	}	
	
}
