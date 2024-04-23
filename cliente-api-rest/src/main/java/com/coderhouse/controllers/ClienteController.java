package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Cliente;
import com.coderhouse.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	// Antoación que nos permite resolver e inyectar entre recursos sin autorización
	@Autowired
	private ClienteService clienteService;
	
	// Definimos las requests GET y POST
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Cliente>> listarClientes(){
		try {
		List<Cliente> listaDeClientes = clienteService.listarClientes();
		return new ResponseEntity<>(listaDeClientes, HttpStatus.OK); // Código 200
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> listarClientePorDNI(@PathVariable("id") Integer clienteId) {
	try {
		Cliente cliente = clienteService.listarClientePorId(clienteId);
		if (cliente != null) {
			return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); // Codigo 404
		}
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
		clienteService.agregarCliente(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
		
	}
	
}