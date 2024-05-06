package com.coderhouse.controladores;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Gestión de Clientes", description = "Endpoints para gestionar los clientes del comercio")
public class ClienteControlador {
	
	// El controlador accede al servicio para llamar sus métodos
	@Autowired
	private ClienteServicio clienteService;
	
	// Solicitud GET que nos devuelve la información de los clientes en formato JSON
	@Operation(summary = "Listar todos los clientes", description = "Devuelve una lista con todos los clientes registrados en el sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de clientes obtenida correctamente",
			content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			}),
			@ApiResponse(responseCode = "500", description = "Error al recuperar la información sobre los clientes",
			content = {
					@Content})
	})
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

	@Operation(summary = "Lista un cliente", description = "Devuelve un objeto del tipo cliente con base en el ID contenido en el sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "El cliente fue obtenida correctamente",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
					}),
			@ApiResponse(responseCode = "500", description = "Error al recuperar la información del cliente",
					content = {
							@Content})
	})
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

	@Operation(summary = "Agregar un cliente", description = "Agrega un nuevo cliente al sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "El cliente fue agregado correctamente",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
					}),
			@ApiResponse(responseCode = "500", description = "Error al agregar el cliente",
					content = {
							@Content})
	})
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

	@Operation(summary = "Modificar un cliente", description = "Modifica los datos de un cliente en el sistema")
	@ApiResponse(responseCode = "200", description = "El cliente fue modificado correctamente",
			content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class))
			})
	@ApiResponse(responseCode = "304", description = "Error al modificar los datos del cliente",
			content = {
					@Content})
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

	@Operation(summary = "Eliminar un cliente", description = "Elimina un cliente del sistema")
	@ApiResponse(responseCode = "200", description = "El cliente fue eliminado correctamente",
			content = {
					@Content(mediaType = "application/json")
			})
	@ApiResponse(responseCode = "500", description = "Error al eliminar el cliente",
			content = {
					@Content})
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
