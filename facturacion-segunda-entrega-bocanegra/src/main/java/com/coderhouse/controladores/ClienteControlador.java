package com.coderhouse.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.modelos.Cliente;
import com.coderhouse.servicios.ClienteServicio;

// Con estas anotaciones, le informamos a Spring que al acceder al url, nos debe llevar a este controlador
@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
	
	// El controlador accede al servicio para llamar sus métodos
	@Autowired
	private ClienteServicio clienteService;
	
	// Solicitud GET que nos devuelve la información en formato JSON
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarClientes(){
		try {
			List<Cliente> listaDeClientes = clienteService.listarClientes();
			return new ResponseEntity<> (listaDeClientes, HttpStatus.OK); 
		} catch (Exception e) {
			String mensajeDeError = "Error al recuperar la información sobre los clientes.";
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@GetMapping(value = "/{cliente_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarClientePorId(@PathVariable("cliente_id") Integer clienteId){
		try {
			Cliente cliente = clienteService.listarClientePorId(clienteId);
			return new ResponseEntity<> (cliente, HttpStatus.OK); 
		} catch (Exception e) {
			String mensajeDeError = "Error al recuperar la información del cliente " + clienteId;
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
