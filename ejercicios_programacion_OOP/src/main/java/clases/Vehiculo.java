package clases;

// Clase correspondiente al ejercicio 1

public class Vehiculo {
	private String marca;
	private String modelo;
	
	// Getters y Setters
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	// Métodos acelerar() y frenar()
	public void acelerar() {
		System.out.println("El vehículo está acelerando. ");
	}
	
	public void frenar() {
		System.out.println("El vehículo está frenando. ");
	}
	
	// Constructores
	public Vehiculo(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
