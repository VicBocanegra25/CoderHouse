package com.coderhouse.controladores;

import java.util.List;

import com.coderhouse.modelos.Producto;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.modelos.Compra;
import com.coderhouse.servicios.CompraServicio;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/compras")
@Tag(name = "Gestión de Compras", description = "Endpoints para gestionar las compras del comercio")
public class CompraControlador {
 	@Autowired
    private CompraServicio compraServicio;

    @Operation(summary = "Listar todas las compras", description = "Devuelve una lista con todas las compras registradas en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de compras obtenida correctamente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Compra.class))
                    }),
            @ApiResponse(responseCode = "500", description = "Error al recuperar la información sobre las compras",
                    content = {
                            @Content})
    })
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Compra>> listarCompras() {
        try {
            List<Compra> compras = compraServicio.listarCompras();
            return new ResponseEntity<>(compras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Lista una compra", description = "Devuelve un objeto del tipo compra con base en el ID contenido en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compra obtenida correctamente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Compra.class))
                    }),
            @ApiResponse(responseCode = "404", description = "No se encontró la compra con ese ID",
                    content = {
                            @Content}),
            @ApiResponse(responseCode = "500", description = "Error al recuperar la información sobre la compra",
                    content = {
                            @Content})
    })
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

    @Operation(summary = "Agregar una compra", description = "Agrega una nueva compra al sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Compra agregada correctamente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Compra.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Error al agregar la compra",
                    content = {
                            @Content}),
            @ApiResponse(responseCode = "500", description = "Error al agregar la compra",
                    content = {
                            @Content})
    })
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

    @Operation(summary = "Eliminar una compra", description = "Elimina una compra del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Compra eliminada correctamente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Compra.class))
                    }),
            @ApiResponse(responseCode = "404", description = "No se encontró la compra con ese ID",
                    content = {
                            @Content}),
            @ApiResponse(responseCode = "500", description = "Error al eliminar la compra",
                    content = {
                            @Content})
    })
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
