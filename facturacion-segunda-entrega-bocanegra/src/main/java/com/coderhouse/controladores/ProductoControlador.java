package com.coderhouse.controladores;

import java.util.List;

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
public class ProductoControlador {

	// El controlador accede al servicio para llamar sus métodos
	@Autowired
	private ProductoServicio productoService;
	
	// Solicitud GET que nos devuelve la información en formato JSON
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
