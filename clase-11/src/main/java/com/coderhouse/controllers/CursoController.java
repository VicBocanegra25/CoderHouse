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

import com.coderhouse.modelos.Curso;
import com.coderhouse.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Curso>> listarCursos() {
		try {
			List<Curso> cursos = cursoService.listaCursos();
			return new ResponseEntity<>(cursos, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
	
	@GetMapping(value = "/{curso_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> listarCursoPorId(@PathVariable("curso_id") Integer cursoId){ 
		try {
			Curso curso = cursoService.listarCursoPorId(cursoId);
			// Validación
			if (curso != null) {
				return new ResponseEntity<> (curso, HttpStatus.OK);				
			} else {
				return new ResponseEntity<> (curso, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	// Con PostMapping enviamos información a la bd en lugar de solicitarla
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso){
		Curso cursoGuardado = cursoService.agregarCurso(curso);
		// Y regresamos un código 201
		return new ResponseEntity<>(cursoGuardado, HttpStatus.CREATED);
	}
	
	// Modificando cursos por id
	@PutMapping(value = "/{curso_id}/modificar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> modificarAlumnosPorId(@PathVariable("curso_id") Integer cursoId, @RequestBody Curso cursoActualizado){ 
		try {
			// Validación.
			if (cursoActualizado != null) {
				// Actualizamos
				cursoService.editarCursoPorDNI(cursoId, cursoActualizado);
				return new ResponseEntity<> (cursoActualizado, HttpStatus.OK);	// Código 200			
			} else {
				return new ResponseEntity<> (cursoActualizado, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	// Eliminando un recurso
	@DeleteMapping("/{curso_id}/eliminar")
	public ResponseEntity<?> eliminarCursoPorId(@PathVariable("curso_id") Integer cursoId){
		try {
			cursoService.eliminarCursoPorDNI(cursoId);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
