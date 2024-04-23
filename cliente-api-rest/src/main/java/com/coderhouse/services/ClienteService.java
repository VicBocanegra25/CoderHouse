package com.coderhouse.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Cliente;
import com.coderhouse.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	// Definimos los métodos GET y POST
	public List<Cliente> listarClientes() {
		List<Cliente> listaDeClientes = clienteRepository.findAll();
		// A cada cliente de la lista, se le calcula la edad y se pasa a la función
		listaDeClientes.forEach(this::calcularEdadDelCliente);
		listaDeClientes.forEach(this::reportarUbicacion);
		return listaDeClientes;
	}
	
	public Cliente listarClientePorId(Integer clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
		// Validación
		if (cliente != null ) {
			calcularEdadDelCliente(cliente);
			reportarUbicacion(cliente);
			
		}
		return cliente;
	}
	
	public Cliente agregarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	// Dentro de la capa de servicios, calculamos la edad del Cliente
	public void calcularEdadDelCliente(Cliente cliente) {
		// Para calcular la edad del cliente, necesitamos la fecha actual
		LocalDate fechaActual = LocalDate.now();
		// Validación (sobre el contenido de la fecha de nacimiento del cliente)
		if (cliente.getFechaNacimiento() != null) {
			// El método between calcula la diferencia entre dos objetos LocalDate
			Integer edad =  Period.between(cliente.getFechaNacimiento(), fechaActual).getYears();
			cliente.setEdad(edad);
		} else {
			System.out.println("Hubo un error al calcular la edad del Cliente.");
		}
	}
	
	// Un método para cambiar la ubicación del cliente de forma aleatoria (no hay persistencia).
	public void reportarUbicacion(Cliente cliente) {
		String ubicacion = "";
		String[] listaDePaises = {"Argentina", "México", "Brazil", "Venezuela", "Estados Unidos"};
		Random rand = new Random(); 
		ubicacion = listaDePaises[rand.nextInt(0, listaDePaises.length)];
		cliente.setUbicacion(ubicacion);		
	}
}
