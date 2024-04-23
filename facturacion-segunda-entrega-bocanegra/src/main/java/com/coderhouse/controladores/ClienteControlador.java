package com.coderhouse.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(value = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> agregarCliente(@RequestBody Cliente nuevocliente){
		try {
		Cliente cliente = clienteService.agregarCliente(nuevocliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	} catch (Exception e) {
		String mensajeDeError = "Error al agregar el cliente. ";
        return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{cliente_id}/modificar", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> modificarClientePorId(@PathVariable("cliente_id") Integer clienteId, @RequestBody Cliente clienteModificado){
		try {
			Cliente cliente = clienteService.editarClientePorID(clienteId, clienteModificado);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			String mensajeDeError = "Error al modificar los datos del cliente. ";
	        return new ResponseEntity<>(mensajeDeError, HttpStatus.NOT_MODIFIED);
		}
	}
	
	@DeleteMapping(value = "/{cliente_id}/eliminar", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> eliminarClientePorId(@PathVariable("cliente_id") Integer clienteId){
		try {
			String mensaje = "El cliente con id: " + clienteId + " fue eliminado correctamente.";
			clienteService.eliminarClientePorId(clienteId);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			String mensajeDeError = "Error al eliminar al cliente. ";
	        return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
