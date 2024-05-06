package com.coderhouse.controladores;

import java.util.List;

import com.coderhouse.modelos.Cliente;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.modelos.Producto;
import com.coderhouse.servicios.ProductoServicio;

@RestController
@RequestMapping("/productos")
@Tag(name = "Gestión de Productos", description = "Endpoints para gestionar los productos del comercio")
public class ProductoControlador {

	// El controlador accede al servicio para llamar sus métodos
	@Autowired
	private ProductoServicio productoService;
	
	// Solicitud GET que nos devuelve la información del producto en formato JSON
	@Operation(summary = "Listar todos los productos", description = "Devuelve una lista con todos los productos registrados en el sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
					}),
			@ApiResponse(responseCode = "500", description = "Error al recuperar la información sobre los productos",
					content = {
							@Content})
	})
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarProductos(){
		try {
			List<Producto> listaDeProductos = productoService.listarProductos();
			return new ResponseEntity<> (listaDeProductos, HttpStatus.OK); 
		} catch (Exception e) {
			String mensajeDeError = "Error al recuperar la información sobre los productos.";
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "Lista un producto", description = "Devuelve un objeto del tipo producto con base en el ID contenido en el sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto obtenido correctamente",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
					}),
			@ApiResponse(responseCode = "500", description = "Error al recuperar la información sobre el producto",
					content = {
							@Content})
	})
	@GetMapping(value = "/{producto_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarProductoPorId(@PathVariable("producto_id") Integer productoId){
		try {
			Producto producto = productoService.listarProductoPorId(productoId);
			return new ResponseEntity<> (producto, HttpStatus.OK); 
		} catch (Exception e) {
			String mensajeDeError = "Error al recuperar la información del producto " + productoId;
            return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Agregar un producto", description = "Agrega un nuevo producto al sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Producto agregado correctamente",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
					}),
			@ApiResponse(responseCode = "500", description = "Error al agregar el producto",
					content = {
							@Content})
	})
	@PostMapping(value = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> agregarProducto(@RequestBody Producto nuevoproducto){
		try {
		Producto producto = productoService.agregarProducto(nuevoproducto);
		return new ResponseEntity<>(producto, HttpStatus.CREATED);
	} catch (Exception e) {
		String mensajeDeError = "Error al agregar el producto. ";
        return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Modificar un producto", description = "Modifica los datos de un producto en el sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto modificado correctamente",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class))
					}),
			@ApiResponse(responseCode = "304", description = "Error al modificar los datos del producto",
					content = {
							@Content})
	})
	@PutMapping(value = "/{producto_id}/modificar", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> modificarProductoPorId(@PathVariable("producto_id") Integer productoId, @RequestBody Producto productoModificado){
		try {
			Producto producto = productoService.editarProductoPorId(productoId, productoModificado);
			return new ResponseEntity<>(producto, HttpStatus.OK);
		} catch (Exception e) {
			String mensajeDeError = "Error al modificar los datos del producto. ";
	        return new ResponseEntity<>(mensajeDeError, HttpStatus.NOT_MODIFIED);
		}
	}

	@Operation(summary = "Eliminar un producto", description = "Elimina un producto del sistema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto eliminado correctamente",
					content = {
							@Content(mediaType = "application/json")
					}),
			@ApiResponse(responseCode = "500", description = "Error al eliminar el producto",
					content = {
							@Content})
	})
	@DeleteMapping(value = "/{producto_id}/eliminar", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> eliminarProductoPorId(@PathVariable("producto_id") Integer productoId){
		try {
			String mensaje = "El producto con id: " + productoId + " fue eliminado correctamente.";
			productoService.eliminarProductoPorId(productoId);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			String mensajeDeError = "Error al eliminar al producto. ";
	        return new ResponseEntity<>(mensajeDeError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
