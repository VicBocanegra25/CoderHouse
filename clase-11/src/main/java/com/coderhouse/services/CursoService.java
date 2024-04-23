package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coderhouse.modelos.Curso;
import com.coderhouse.repositorios.CursoRepository;

@Service
public class CursoService {

	// Invocamos un repositorio
	@Autowired
	private CursoRepository cursoRepository; 
	
	// Colocamos los métodos para realizar las operaciones en la bd
		public List<Curso> listaCursos(){
			return cursoRepository.findAll();
		}
		
		public Curso listarCursoPorId(Integer dni) {
			return cursoRepository.findById(dni).orElse(null);
		}
		
		public Curso agregarCurso(Curso nuevoCurso) {
			return cursoRepository.save(nuevoCurso);
		}
		
		public Curso editarCursoPorDNI(Integer dni, Curso cursoModificado) {
			try {
			if (cursoRepository.existsById(dni)) {
				cursoModificado.setId_curso(dni);
				return cursoRepository.save(cursoModificado);
				}
			} catch (EmptyResultDataAccessException e) {
				System.out.println("No se encontró el curso");
			}
			return null;
		}
		
		public boolean eliminarCursoPorDNI(Integer dni) {
			try {
			if (cursoRepository.existsById(dni)) {
				cursoRepository.deleteById(dni);
				return true;
				}
			} catch (EmptyResultDataAccessException e) {
				System.out.println("No se encontró el curso");
			}
			return false;
		}
	
}
