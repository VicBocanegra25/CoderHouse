package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
import org.springframework.web.server.ResponseStatusException;

import com.coderhouse.modelos.Alumno;
import com.coderhouse.services.AlumnoService;

// Con estas anotaciones, le informamos a Spring que al acceder al Url, nos debe llevar a este controlador
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private com.coderhouse.services.AlumnoService alumnoService;
	
	// Solicitud GET que nos devuelve un JSON
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Alumno>> listarAlumnos(){
		try {
			List<Alumno> alumnos = alumnoService.listaAlumnos();
			return new ResponseEntity<> (alumnos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	@GetMapping(value = "/{dni}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Alumno> listarAlumnosPorDNI(@PathVariable("dni") Integer dni){ 
		try {
			Alumno alumno = alumnoService.listarAlumnoPorDNI(dni);
			// Validación
			if (alumno != null) {
				return new ResponseEntity<> (alumno, HttpStatus.OK);				
			} else {
				return new ResponseEntity<> (alumno, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	// Con PostMapping enviamos información a la bd en lugar de solicitarla
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Alumno> agregarAlumno(@RequestBody Alumno alumno){
		// El repositorio salvará el alumno que le enviamos como parámetro (JSON)
		alumnoService.agregarAlumno(alumno);
		// Y regresamos un código 201
		return new ResponseEntity<>(alumno, HttpStatus.CREATED);
	}
	
	
	// Modificando alumnos por dni
	@PutMapping(value = "/{dni}/modificar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Alumno> modificarAlumnosPorDNI(@PathVariable("dni") Integer dni, @RequestBody Alumno alumnoActualizado){ 
		try {
			// Validación.
			if (alumnoActualizado != null) {
				// Actualizamos
				alumnoService.editarAlumnoPorDNI(dni, alumnoActualizado);
				return new ResponseEntity<> (alumnoActualizado, HttpStatus.OK);	// Código 200			
			} else {
				return new ResponseEntity<> (alumnoActualizado, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	// Eliminando un recurso
	@DeleteMapping("/{dni}/eliminar")
	public ResponseEntity<?> eliminarAlumnoPorDNI(@PathVariable Integer dni){
		try {
			alumnoService.eliminarAlumnoPorDNI(dni);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
