package ejercicios_avanzados.clases;

import java.util.Objects;

// Clase libro, con título, autor y un isbn como atributos, como lo indica el ejercicio 41

public class Libro {
	// Declaramos los atributos
	private String titulo;
	private String autor;
	private long ISBN;
	
	// Seguiidos por sus getters y setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
	// Colocamos los constructores
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Libro(String titulo, String autor, long ISBN) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return ISBN == other.ISBN;
	}
	
	// Implemenetamos el equals() y hashCode() para comparar los objetos por ISBN.

	

}
