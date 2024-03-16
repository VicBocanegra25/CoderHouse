package com.coderhouse;

import com.coderhouse.controlador.JavaDataBaseController;
import com.coderhouse.entidades.Alumno;

public class MainTest {
	public static void main(String[] args) {
		// Instanciamos la clase JDBC
		JavaDataBaseController controller = new JavaDataBaseController();
		
		controller.getConnection();
		
		
		System.out.println("MENSAJE DEL MEDIO");
		Alumno alumno = new Alumno();
		
//		for (int i=0; i < 100; i++) {
//			
//			alumno.setDni(10000 + i);
//			alumno.setNombre("Nombre" + i);
//			alumno.setApellido("Apellido" + i);
//			alumno.setLegajo(alumno.hashCode());
//
//			controller.insertarAlumno(alumno);
//		}
		controller.modificarAlumno(10000, "Ernesto" , "Sabato");
		controller.mostrarAlumnos();
		
		// Se elimina el alumno con dni 10099
		controller.eliminarAlumno(10099);
		
		controller.mostrarAlumnos();

		controller.closeConnection();
	}
}
