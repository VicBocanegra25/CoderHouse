package com.coderhouse.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.coderhouse.entidades.Alumno;
import com.coderhouse.entidades.Curso;

// Esta clase simula el JDBC
public class JavaDataBaseController {

	private static final String DATA_BASE="coderhouse";
	private static final String URL="jdbc:mysql://localhost:3306/" + DATA_BASE; 
	private static final String USER="root";
	private static final String PASSWORD="root";
	
	private Connection connection;
	
	// Método para conectar con la base de datos
	public Connection getConnection() {
		if (connection == null) {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión exitosa a la base de datos: " + DATA_BASE);
		} catch (SQLException e) {
			System.out.println("Error al establecer la conexión " + e.getMessage());
			}
		}
		return connection;

	}
	
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Conexión cerrada.");
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexión. " + e.getMessage());
			}		
		}
	}
	
	// Comienzan los métodos CRUD

	
	// CREATE (Método para insertar un nuevo alumno a la db). 
	
	public void insertarAlumno(Alumno alumno) {
		
		// Puesto que se realiza una inserción a la BD, utilizamos el objeto PreparedStatement
		PreparedStatement statement = null;
		
		// Utilizamos los placeholders '?' para pasarles el valor por medio de números 
		String query = "INSERT INTO alumnos (dni, apellido, id_curso, legajo, nombre)  VALUES (?, ?, ?, ?, ?)";

		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, alumno.getDni());
			statement.setString(2, alumno.getApellido());
			statement.setInt(3, alumno.getIdCurso());
			statement.setInt(4, alumno.hashCode());
			statement.setString(5, alumno.getNombre());
			int rowsAffected = statement.executeUpdate();
			
			// Este condicional nos sirve para indicarle al usuario que no se pudo realizar la inserción del alumno
			if (rowsAffected == 0) {
				throw new SQLException(
						"No se pudo insertar el alumno: " + alumno.getNombre() + " " + alumno.getApellido());
			}
			System.out.println(
					"El Alumno " + alumno.getNombre() + " " + alumno.getApellido() + " fue insertado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}
	
	// READ (Devuelve todos los alumnos)
	public void mostrarAlumnos() {
		Statement statement = null;
		ResultSet resultSet = null;
		
		// Declaramos la query para obtener los alumnos de la db
		String query = "SELECT dni, nombre, apellido, legajo, id_curso FROM alumnos";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			// Iteramos sobre el resultSet (es un iterator, utilizamos el método .next().
			while (resultSet.next()) {
				// Salvamos la información en variables locales
				Integer dni = resultSet.getInt("dni");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String legajo = resultSet.getString("legajo");
				Integer id_curso = resultSet.getInt("id_curso");

				System.out.println("Alumno con DNI Nro " + dni + " es " + nombre + " " + apellido
						+ " está cursando la clase con ID: " + id_curso +", y su Legajo es el Nro: " + legajo);
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { 
				// Se cierran las queries
				if (resultSet != null) {
					resultSet.close();
				} 
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar el statement o el resultSet " + e.getMessage());
			}
		}
	}
	
	// READ (by ID) - Este método muestra un alumno en específico, a partir del dni
	public void mostrarAlumnoConDNI(Integer dni_) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		// Declaramos la query para obtener los alumnos de la db
		String query = "SELECT dni, nombre, apellido, legajo, id_curso FROM alumnos WHERE dni = ?";
		
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, dni_);
			resultSet =  statement.executeQuery();
			if (resultSet.next() == false) {
				throw new SQLException("No se pudo recuperar el alumno con DNI: " + dni_);
			}

		// Modificamos el while por un do-while ya que el iterador se recorrió durante el chequeo: resultSet.next() == false
		do {
			// Salvamos la información en variables locales
			Integer dni = resultSet.getInt("dni");
			String nombre = resultSet.getString("nombre");
			String apellido = resultSet.getString("apellido");
			String legajo = resultSet.getString("legajo");
			Integer id_curso = resultSet.getInt("id_curso");

			System.out.println("Alumno con DNI Nro " + dni + " es " + nombre + " " + apellido
					+ ". Está cursando la clase con ID: " + id_curso +", y su Legajo es el Nro: " + legajo);
			} while (resultSet.next());
		
		} catch (SQLException e) {
			System.out.println("Error al obtener al alumno con dni " + dni_);
			System.out.println(e.getMessage());
		} finally {
			try { 
				// Se cierran las queries
				if (resultSet != null) {
					resultSet.close();
				} 
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar el statement o el resultSet " + e.getMessage());
				}	
		}
	}
	
	// UPDATE (Método para modificar un elemento existente de la db)
	public void modificarAlumno(Integer dni, String nuevoNombre, String nuevoApellido) {
		PreparedStatement statement = null;
		try {

			String query = "UPDATE alumnos SET nombre = ?, apellido = ? WHERE dni = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, nuevoNombre);
			statement.setString(2, nuevoApellido);
			statement.setInt(3, dni);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new SQLException("No se pudo modificar el alumno con DNI: " + dni);
			}
			System.out.println("El Alumno con DNI " + dni + " fue modificado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}
	
	// DELETE (Método para eliminar un elemento existente - Se utiliza el dni para localizar al alumno)
	public void eliminarAlumno(Integer dni) {
		PreparedStatement statement = null;
		try {
			String query = "DELETE FROM alumnos WHERE dni = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, dni);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new SQLException("No se pudo eliminar al alumno con DNI: " + dni);
			}
			System.out.println("El Alumno con DNI " + dni + " fue eliminado correctamente");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}

	}
	
	/* 
	 * En esta parte del JDBC, implementamos el CRUD para la tabla cursos
	 */
	// CREATE - Método para insertar cursos en la tabla cursos
		public void insertarCurso(Curso curso) {
		PreparedStatement statement = null;
		String query = "INSERT INTO cursos (titulo, descripcion) VALUES (?, ?)";

		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, curso.getTitulo());
			statement.setString(2, curso.getDescripcion());
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new SQLException("No se pudo insertar el curso: " + curso.getTitulo());
			}
			System.out.println("El Curso " + curso.getTitulo() + " fue insertado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}
	// READ (Devuelve todos los cursos)
	public void mostrarCursos() {
		Statement statement = null;
		ResultSet resultSet = null;
		
		// Declaramos la query para obtener los alumnos de la db
		String query = "SELECT id_curso, descripcion, titulo FROM cursos";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			// Iteramos sobre el resultSet (es un iterator, utilizamos el método .next().
			while (resultSet.next()) {
				// Salvamos la información en variables locales
				Integer idCurso = resultSet.getInt("id_curso");
				String descripcion = resultSet.getString("descripcion");
				String titulo = resultSet.getString("titulo");

				System.out.println("El curso con el ID Nro " + idCurso + " es " + titulo + "-" +
				descripcion);
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { 
				// Se cierran las queries
				if (resultSet != null) {
					resultSet.close();
				} 
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar el statement o el resultSet " + e.getMessage());
			}
		}
	}
	
	// READ (by ID) - Este método muestra un alumno en específico, a partir del dni
	public void mostrarCursoConId(Integer idCurso_) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		// Declaramos la query para obtener los alumnos de la db
		String query = "SELECT id_curso, descripcion, titulo FROM cursos WHERE id_curso = ?";
		
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, idCurso_);
			resultSet =  statement.executeQuery();
			if (resultSet.next() == false) {
				throw new SQLException("No se pudo recuperar el curso con ID: " + idCurso_);
			}

		// Modificamos el while por un do-while ya que el iterador se recorrió durante el chequeo: resultSet.next() == false
		do {
			// Salvamos la información en variables locales
			Integer idCurso = resultSet.getInt("id_curso");
			String descripcion = resultSet.getString("descripcion");
			String titulo = resultSet.getString("titulo");

			System.out.println("El curso con ID Nro " + idCurso + " es " + titulo + "-" + descripcion + ".");
			} while (resultSet.next());
		
		} catch (SQLException e) {
			System.out.println("Error al obtener al curso con ID: " + idCurso_);
			System.out.println(e.getMessage());
		} finally {
			try { 
				// Se cierran las queries
				if (resultSet != null) {
					resultSet.close();
				} 
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar el statement o el resultSet " + e.getMessage());
				}	
		}
	}
	
	// UPDATE (Método para modificar un elemento (CURSO) existente de la db)
	public void modificarCurso(Integer idCurso, String nuevoTitulo, String nuevaDescripcion) {
		PreparedStatement statement = null;
		try {

			String query = "UPDATE cursos SET titulo = ?, descripcion = ? WHERE id_curso = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, nuevoTitulo);
			statement.setString(2, nuevaDescripcion);
			statement.setInt(3, idCurso);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new SQLException("No se pudo modificar el curso con ID: " + idCurso);
			}
			System.out.println("El curso con ID " + idCurso + " fue modificado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}
	
	// DELETE (Método para eliminar un elemento (CURSO) existente - Se utiliza el id_curso para localizar al curso)
	public void eliminarCurso(Integer idCurso) {
		PreparedStatement statement = null;
		try {
			String query = "DELETE FROM cursos WHERE id_curso = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idCurso);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new SQLException("No se pudo eliminar el curso con ID: " + idCurso);
			}
			System.out.println("El curso con ID: " + idCurso + " fue eliminado correctamente");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}

	}
	
	// Método auxiliar para limpiar la bd. Se utiliza DROP para eliminar las tablas, pero se comienza con Alumno (por las primary key constraints)
	public void limpiarBD() {
		Statement statement = null;
		try {
	        statement = connection.createStatement();
	        statement.executeUpdate("DROP TABLE IF EXISTS alumnos");
	        statement.executeUpdate("DROP TABLE IF EXISTS cursos");

			System.out.println("La base de datos fue limpiada correctamente.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}

	}
		
		
}
