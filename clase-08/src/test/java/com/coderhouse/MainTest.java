package com.coderhouse;

import java.util.Random;

import com.coderhouse.controlador.JavaDataBaseController;
import com.coderhouse.entidades.Alumno;
import com.coderhouse.entidades.Curso;

public class MainTest {
	public static void main(String[] args) {
		// Instanciamos la clase JDBC
		JavaDataBaseController controller = new JavaDataBaseController();
		
		controller.getConnection();
		
		// Se generan 100 alumnos
		System.out.println("MENSAJE DEL MEDIO");
		Random rand = new Random();
		Alumno alumno = new Alumno();
		
		// Se insertan dos cursos
		Curso cursoUno = new Curso();
		Curso cursoDos = new Curso();
		cursoUno.setTitulo("Introducción a Java");
		cursoUno.setDescripcion("Curso de Introducción a Java, Spring y Hibernate.");
		cursoDos.setTitulo("Spring Boot");
		cursoDos.setDescripcion("Curso de Introducción al Framework Spring Boot.");
		
		controller.insertarCurso(cursoUno);
		controller.insertarCurso(cursoDos);
		
		
		for (int i=0; i < 100; i++) {
			
			alumno.setDni(10000 + i);
			alumno.setNombre("Nombre" + i);
			alumno.setApellido("Apellido" + i);
			alumno.setLegajo(alumno.hashCode());
			alumno.setIdCurso(1 + rand.nextInt(2));

			controller.insertarAlumno(alumno);
		}
	
		// Se modifica el primer alumno
		controller.modificarAlumno(10001, "Ernesto" , "Sabato");
		controller.mostrarAlumnos();
		
		// Se elimina el alumno con dni 10099
		controller.eliminarAlumno(10099);
		
		controller.mostrarAlumnos();

		// Mostremos al alumno con dni: 10001
		System.out.println("***MOSTRANDO ALUMNO ***");
		controller.mostrarAlumnoConDNI(10001);
		
		controller.closeConnection();
	}
}
