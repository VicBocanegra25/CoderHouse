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
import com.coderhouse.modelos.Curso;
import com.coderhouse.repositorios.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Curso>> listarCursos() {
		try {
			List<Curso> cursos = cursoRepository.findAll();
			return new ResponseEntity<>(cursos, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
	
	@GetMapping(value = "/{curso_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> mostrarCursoPorId(@PathVariable("curso_id") Integer cursoId){ 
		try {
			Curso curso = cursoRepository.findById(cursoId).orElse(null);
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
		cursoRepository.save(curso);
		// Y regresamos un código 201
		return new ResponseEntity<>(curso, HttpStatus.CREATED);
	}
	
	// Eliminando un recurso
	@DeleteMapping("/{curso_id}/eliminar")
	public ResponseEntity<?> eliminarCursoPorId(@PathVariable("curso_id") Integer cursoId){
		try {
			cursoRepository.deleteById(cursoId);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Modificando cursos por id
	@PutMapping(value = "/{curso_id}/modificar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Curso> modificarAlumnosPorId(@PathVariable("curso_id") Integer cursoId, @RequestBody Curso cursoActualizado){ 
		try {
			// Obtenemos al alumno con ese ID
			Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el curso"));
			// Validación.
			if (curso != null) {
				// Actualizamos
				curso.setTitulo(cursoActualizado.getTitulo());
				curso.setDescripcion(cursoActualizado.getDescripcion());
				cursoRepository.save(curso);
				return new ResponseEntity<> (curso, HttpStatus.OK);				
			} else {
				return new ResponseEntity<> (curso, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
}
