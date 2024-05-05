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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.modelos.Compra;
import com.coderhouse.servicios.CompraServicio;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/compras")
public class CompraControlador {
 	@Autowired
    private CompraServicio compraServicio;


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Compra>> listarCompras() {
        try {
            List<Compra> compras = compraServicio.listarCompras();
            return new ResponseEntity<>(compras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{compraId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarCompraPorId(@PathVariable Integer compraId) {
        try {
            Compra compra = compraServicio.listarCompraPorID(compraId);
            return compra != null ? new ResponseEntity<>(compra, HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
        	String mensaje = "No se encontró la compra con ese ID";
            return new ResponseEntity<>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> agregarCompra(@RequestBody Compra compra) {
    	try {
    		Compra nuevaCompra = compraServicio.agregarCompra(compra);
    		return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
    	} catch (IllegalArgumentException e) {
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	} catch (Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }

    @DeleteMapping(value = "/{compraId}/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarCompra(@PathVariable Integer compraId) {
        try {
            compraServicio.eliminarCompraPorId(compraId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
