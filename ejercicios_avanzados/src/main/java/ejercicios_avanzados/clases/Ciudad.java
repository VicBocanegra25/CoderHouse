package ejercicios_avanzados.clases;

import java.util.Objects;

// Clase correspondiente al ejercicio 49

public class Ciudad {
	private String nombre;
	private int codigoPostal;
	
	// Getters, setters.
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	// Constructores
	public Ciudad(String nombre, int codigoPostal) {
		super();
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
	}
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// equals y hashCode, las ciudades son la misma si tienen el mismo CP
	@Override
	public int hashCode() {
		return Objects.hash(codigoPostal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return codigoPostal == other.codigoPostal;
	}
	
	
	
}
