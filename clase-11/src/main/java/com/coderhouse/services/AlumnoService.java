package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coderhouse.modelos.Alumno;
import com.coderhouse.repositorios.AlumnoRepository;

@Service
public class AlumnoService {
	// El servicio se conecta directamente con el repositorio
	@Autowired
	private AlumnoRepository alumnoRepository;

	// Colocamos los métodos para realizar las operaciones en la bd
	public List<Alumno> listaAlumnos(){
		return alumnoRepository.findAll();
	}
	
	public Alumno listarAlumnoPorDNI(Integer dni) {
		return alumnoRepository.findById(dni).orElse(null);
	}
	
	public Alumno agregarAlumno(Alumno nuevoAlumno) {
		return alumnoRepository.save(nuevoAlumno);
	}
	
	public Alumno editarAlumnoPorDNI(Integer dni, Alumno alumnoModificado) {
		try {
		if (alumnoRepository.existsById(dni)) {
			alumnoModificado.setDni(dni);
			return alumnoRepository.save(alumnoModificado);
			}
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No se encontró el alumno");
		}
		return null;
	}
	
	public boolean eliminarAlumnoPorDNI(Integer dni) {
		try {
		if (alumnoRepository.existsById(dni)) {
			alumnoRepository.deleteById(dni);
			return true;
			}
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No se encontró el alumno");
		}
		return false;
	}
}
