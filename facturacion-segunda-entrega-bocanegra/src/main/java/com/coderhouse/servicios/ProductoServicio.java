package com.coderhouse.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coderhouse.modelos.Producto;
import com.coderhouser.repositorios.ProductoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoServicio {

	// El servicio se conecta directametne con el repositorio
	@Autowired
	private ProductoRepositorio productoRepository; 
	
	// Declaramos métodos para realizar las operaciones CRUD en la base de datos
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}
	
	public Producto listarProductoPorID(Integer productoId) {
		return productoRepository.findById(productoId).orElseThrow(() -> new EntityNotFoundException("No se encontró un producto con id " + productoId));
	}
	
	public Producto agregarProducto(Producto productoNuevo) {
		return productoRepository.save(productoNuevo);
	}
	
	public Producto editarProductoPorID(Integer productoId, Producto productoModificado) {
		try {
			if (productoRepository.existsById(productoId)) {
				productoModificado.setProductoID(productoId);
				return productoRepository.save(productoModificado);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el producto con id " + productoId);
		}
		return null;
	}
	
	public boolean eliminarProductoPorId(Integer productoId) {
		try {
			if (productoRepository.existsById(productoId)) {
				productoRepository.deleteById(productoId);
				return true;
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el producto con id " + productoId);
		}
		return false;
	}	
	
}
