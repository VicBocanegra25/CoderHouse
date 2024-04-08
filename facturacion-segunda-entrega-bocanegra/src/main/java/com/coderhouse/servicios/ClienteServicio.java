package com.coderhouse.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.coderhouse.modelos.Cliente;
import com.coderhouser.repositorios.ClienteRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServicio {

	// El servicio se conecta directametne con el repositorio
	@Autowired
	private ClienteRepositorio clienteRepository; 
	
	// Declaramos métodos para realizar las operaciones CRUD en la base de datos
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente listarClientePorID(Integer clienteId) {
		return clienteRepository.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("No se encontró un cliente con id " + clienteId));
	}
	
	public Cliente agregarCliente(Cliente clienteNuevo) {
		return clienteRepository.save(clienteNuevo);
	}
	
	public Cliente editarClientePorID(Integer clienteId, Cliente clienteModificado) {
		try {
			if (clienteRepository.existsById(clienteId)) {
				clienteModificado.setClienteID(clienteId);
				return clienteRepository.save(clienteModificado);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el cliente con id " + clienteId);
		}
		return null;
	}
	
	public boolean eliminarClientePorId(Integer clienteId) {
		try {
			if (clienteRepository.existsById(clienteId)) {
				clienteRepository.deleteById(clienteId);
				return true;
			}
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("No se encontró el cliente con id " + clienteId);
		}
		return false;
	}	
	
	
}
