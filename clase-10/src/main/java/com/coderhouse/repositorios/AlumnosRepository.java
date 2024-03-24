package com.coderhouse.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.modelos.Alumno;

// Al declarar este repositorio y extender de Jpa, nos da acceso a los métodos necesarios para acceder a los datos
@Repository
public interface AlumnosRepository extends JpaRepository<Alumno, Integer>{

}
