package ejercicios_avanzados.clases;

import java.util.Objects;

// La clase Coche corresponde al ejercicio 45

public class Coche {
	private String marca;
	private String modelo;
	private int año;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public Coche(String marca, String modelo, int año) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
	}
	@Override
	public int hashCode() {
		return Objects.hash(año, marca, modelo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return año == other.año && Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
	}
	
	
	
}
