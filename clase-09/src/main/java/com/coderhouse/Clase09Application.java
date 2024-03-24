package com.coderhouse;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.entidades.Alumno;
import com.coderhouse.entidades.Curso;
import com.coderhouse.repositorios.AlumnosRepository;
import com.coderhouse.repositorios.CursoRepository;

// La clase implementa una interfaz CommandLineRunner que nos permite sobbre escribir el método run
@SpringBootApplication
public class Clase09Application implements CommandLineRunner{

	@Autowired
	private AlumnosRepository alumnoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Clase09Application.class, args);
		
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		mostrarMenu();
	}
	
	// Utilizamos un switch para mostrar un menú al usuario
	public void mostrarMenu() {
		try {
			Scanner scanner = new Scanner(System.in);
			// Inicializamos con una opción inválida
			int opcion = -1;
			
			do {
				try {
					System.out.println("Menu: \n "
							+ "1. Listar a todos los Alumnos\n "
							+ "2. Agregar Alumno\n "
							+ "3. Buscar Alumno por DNI\n "
							+ "4. Modificar Alumno por DNI\n "
							+ "5. Eliminar Alumno por DNI\n "
							+ "6. Agregar Cursos\n "
							+ "7. Listar Cursos\n "
							+ "8. Buscar Curso por ID\n "
							+ "9. Modifcar Curso por ID\n "
							+ "10. Eliminar Curso por ID\n"
							+ " 0. Salir\n ");
					System.out.println("Ingresar opcion: ");
					
					if(scanner.hasNextInt()) {
						opcion = scanner.nextInt();
						scanner.nextLine();
					} else {
						System.out.println("Entrada Invalida. "
								+ "Debe Ingresar un Numero del Menu");
						scanner.nextLine();
						continue;
					}
					
					switch (opcion) {
					case 1:
						listarTodosLosAlumnos();
						break;
					case 2:
						agregarAlumnos();
						break;
					case 3:
						buscarAlumnoPorDNI();
						break;
					case 4:
						modificarAlumnoPorDNI ();
						break;
					case 5: 
						eliminarAlumnoPorDNI();
						break;
					case 6:
						agregarCursos();
						break;
					case 7:
						mostrarCursos();
						break;
					case 8:
						mostrarCursoPorID();
						break;
					case 9: 
						modificarCursoPorID();
						break;
					case 10: 
						eliminarCursoPorId();
						break;
					case 0:
						System.out.println("Saliendo del Programa...");
						break;
					default:
						System.err.println("Opcion invalida. Ingrese un Numero Valido.");
						break;
					}
					
				} catch (InputMismatchException e ) {
					System.err.println("Error. Ingrese un número válido. ");
					scanner.nextLine(); opcion = -1;
				}
				
			} while (opcion != 0); // El programa termina si el usuario coloca 0
			
			// Cerramos el objeto scanner
			scanner.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Métodos para realizar las operaciones CRUD
	public void listarTodosLosAlumnos() {
		// Con el método findAll() obtenemos todos los elementos
		List<Alumno> listaAlumno = alumnoRepository.findAll();
		// Validamos si la lista tiene contenido
		if(listaAlumno.isEmpty()) {
			System.out.println("No existen alumnos en la para mostrar. ");
		} else {
			System.out.println("Lista de alumnos: \n");
			for (Alumno alumno : listaAlumno) {
				System.out.println("El alumno con DNI: " + alumno.getDni() + " - " +
						alumno.getNombre() + " " + alumno.getApellido() + 
						" asiste al curso: " + alumno.getCurso().getTitulo());
			}
		}
		
	}
	
	public void agregarAlumnos() {
		// Comenzamos por revisar la lista de cursos (porque existe una llave foránea en la tabla)
		List<Curso> listaCursos = cursoRepository.findAll();
		// Validamos si existen cursos
		if (listaCursos.isEmpty()) {
			System.out.println("No existen cursos para mostrar. Se deba gregar al menos un curso. ");
		} else {
			// Utilizmos la clase Scanner para recibir datos por parte del usuario
			Scanner scanner = new Scanner(System.in);
			Alumno alumno = new Alumno();
			
			System.out.println("Ingrese el DNI del alumno: ");
			alumno.setDni(scanner.nextInt());
			
			// Consumimos un salto de línea
			scanner.nextLine();
			
			System.out.println("Ingrese el nombre del alumno: ");
			alumno.setNombre(scanner.nextLine());
			
			System.out.println("Ingrese el apellido del alumno: ");
			alumno.setApellido(scanner.nextLine());
			
			System.out.println("Cursos disponibles: ");
			for (Curso curso : listaCursos) {
				System.out.println(" " + curso.getId_curso() + ". " + curso.getTitulo());
			}
			
			int cursoId;
			Curso cursoSeleccionado = null;
			boolean cursoValido = false;
			
			// Utilizamos un while para asegurarnos de que el usuario selecciona un curso válido
			while (!cursoValido) {
				try { 
					System.out.println("Seleccione el ID del curso: ");
					cursoId = scanner.nextInt();
					cursoSeleccionado = cursoRepository.findById(cursoId).orElse(null);
					// Se valida si el curso seleccionado existe. 
					if (cursoSeleccionado != null) {
						cursoValido = true; 
					}
				} catch (InputMismatchException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
	
	public void buscarAlumnoPorDNI() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el DNI del Alumno a buscar:");		
		int dni = scanner.nextInt();
		
		Alumno alumno = alumnoRepository.findById(dni).orElse(null);
		
		verificarExistenciaAlumno(alumno);
		
	}
	
	public void modificarAlumnoPorDNI () {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el DNI del Alumno a editar:");		
		int dni = scanner.nextInt();
		Alumno alumno = alumnoRepository.findById(dni).orElse(null);
		List<Curso> cursos = cursoRepository.findAll();
		if(cursos.isEmpty()) {
			System.out.println("No existen Cursos para mostrar. "
					+ "Debe agregar al menos un Curso!");
		}
		if(verificarExistenciaAlumno(alumno)) {
			
			System.out.println("Ingrese el nuevo Nombre: ");
			String nuevoNombre = scanner.next();
			alumno.setNombre(nuevoNombre);
			System.out.println("Ingrese el nuevo Apellido: ");
			String nuevoApellido = scanner.next();
			alumno.setApellido(nuevoApellido);
			System.out.println("Cursos Disponibles: ");
			for (Curso curso : cursos) {
				System.out.println(" " + curso.getId_curso() + ". " + curso.getTitulo());
			}
			
			int cursoId;
			Curso cursoSeleccionado = null;
			boolean cursoValido = false;
			
			while(!cursoValido) {
				try {
					
				
				System.out.println("Seleccione el ID del Curso: ");
				cursoId = scanner.nextInt();
				cursoSeleccionado = cursoRepository.findById(cursoId).orElse(null);
				if (cursoSeleccionado != null) {
					cursoValido = true;
				} else {
					System.out.println("El ID del Curso seleccionado no es Valido");
				}
				
				} catch(InputMismatchException e) {
					System.err.println("Error: Ingrese un Numero Valido.");
					scanner.nextLine();
				}
			}
			
			//Asignamos el Curso seleccionado
			alumno.setCurso(cursoSeleccionado);
			
			alumnoRepository.save(alumno);
			System.out.println("Alumno modificado Correctamente");
		}
	}
	
	public void eliminarAlumnoPorDNI() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el DNI del Alumno a editar:");		
		int dni = scanner.nextInt();
		Alumno alumno = alumnoRepository.findById(dni).orElse(null);
		
		if(alumno != null) {
			alumnoRepository.delete(alumno);
			System.out.println("El Alumno fue Eliminado Exitosamente.!");		
		}else {
			System.out.println("Alumno con DNI " + dni + " no fue encontrado!");		
		}
	}
	
	// CRUD para los cursos
	public void agregarCursos() {
		Curso curso = new Curso();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el Titulo del Curso:");	
		curso.setTitulo(scanner.nextLine());
		
		System.out.println("Ingrese la Descripcion del Curso:");	
		curso.setDescripcion(scanner.nextLine());
		
		cursoRepository.save(curso);
		System.out.println("El Curso " + curso.getTitulo() 
							+ " fue Guardado Exitosamente.!");
		
	}
	
	public void mostrarCursos() {
		List<Curso> listaCursos = cursoRepository.findAll();
		// Validación 
		if (listaCursos.isEmpty()) {
			System.out.println("No hay cursos para mostrar. ");
		} else {
			System.out.println("Lista de cursos: ");
			for (Curso curso : listaCursos) {
				System.out.println(curso.getId_curso() + " - " + curso.getTitulo() + " - " + curso.getDescripcion());				
			}
		}
	}
	
	public void mostrarCursoPorID() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el ID del curso a buscar:");		
		int cursoId = scanner.nextInt();
		
		Curso curso = cursoRepository.findById(cursoId).orElse(null);
		
		verificarExistenciaCurso(curso);
		
	}
	
	public void modificarCursoPorID () {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el ID del curso a editar:");		
		int cursoId = scanner.nextInt();
		Curso curso = cursoRepository.findById(cursoId).orElse(null);

		if(verificarExistenciaCurso(curso)) {

			System.out.println("Ingrese el nuevo título del curso: ");
			String nuevoTitulo = scanner.next();
			curso.setTitulo(nuevoTitulo);
			System.out.println("Ingrese la nueva descripción: ");
			String nuevaDescripcion= scanner.next();
			curso.setDescripcion(nuevaDescripcion);
			
			
			cursoRepository.save(curso);
			System.out.println("Curso modificado correctamente");
		}		
	}
	
	public void eliminarCursoPorId() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del curso a eliminar:");		
		int cursoId = scanner.nextInt();
		Curso curso = cursoRepository.findById(cursoId).orElse(null);
		
		if(curso != null) {
			cursoRepository.delete(curso);
			System.out.println("El curso fue Eliminado Exitosamente.!");		
		}else {
			System.out.println("El curso con ID " + cursoId + " no fue encontrado!");		
		}
	}

	// Método auxiliar para verificar la existencia del alumno
	public boolean verificarExistenciaAlumno(Alumno alumno_) {
		if(alumno_ != null) {
			System.out.println("El Alumno seleccionado es: " + alumno_.getNombre() + " "
					+ alumno_.getApellido() + " y se inscribio en el Curso de "
					+ alumno_.getCurso().getTitulo());	
			return true;
		}else {
			System.out.println("Alumno con DNI " + alumno_.getDni() + " no fue encontrado!");		
			return false;
		}
	}
	
	
	public boolean verificarExistenciaCurso(Curso curso_) {
		if(curso_ != null) {
			System.out.println("El curso seleccionado es: " + curso_.getTitulo() + " "
					+ curso_.getDescripcion());	
			System.out.println("Lista de alumnos inscritos en este curso: ");
			List<Alumno> listaAlumnos = curso_.getAlumnos();
			for (Alumno alumno : listaAlumnos) {
				System.out.println(alumno.getNombre() + " " + alumno.getApellido() 
				+ " con DNI " + alumno.getDni());
			}
			return true;
		}else {
			System.out.println("El curso con ID " + curso_.getId_curso() + " no fue encontrado!");		
			return false;
		}
	}
	
	
	

}
