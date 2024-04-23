package com.coderhouse.clases;

//Esta clase representa un vehículo con sus propiedades y métodos
public class Vehiculos {
	
	// Agregamos una constante para lasruedas
	private static final int CANTIDADDERUEDAS = 4;
	private int cantidadDeRuedas;
	private String marca;
	private String color;
	private float precio;
	private boolean esElectrico;
	private boolean encendido;
	


	// Generamos los getters y setters para nuestros atributos
	public int getCantidadDeRuedas() {
		return cantidadDeRuedas;
	}
	
	// Modificamos el setter de la cantidad de ruedas, para limitarlo
	public void setCantidadDeRuedas(int cantidadDeRuedas) {
		String mensaje = "La cantidad máxima de ruedas permitidas es de: " + CANTIDADDERUEDAS;
		
		if (cantidadDeRuedas > CANTIDADDERUEDAS) {
			System.out.println("Se excedió la cantidad permitida de ruedas. " + mensaje);
		} else {
			this.cantidadDeRuedas = cantidadDeRuedas;
		}
	}
	
	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido() {
		if (this.isEncendido()) { 
			System.out.println("El auto ya se encuentra encendido. ");
		} else {
			System.out.println("El auto se ha encendido. ");
		}
		this.encendido = true;

	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isEsElectrico() {
		return esElectrico;
	}
	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}
	

	
	// Generamos un constructor (que hereda de la clase object)
	public Vehiculos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Generamos un método toString para facilitar la impresión
	@Override
	public String toString() {
		return "Vehiculos [cantidadDeRuedas=" + cantidadDeRuedas + ", marca=" + marca + ", color=" + color + ", precio="
				+ precio + ", esElectrico=" + esElectrico + "]";
	}
	
	// Definimos un método, encender
	public void encender() {
		this.setEncendido();
	}
	
	
}
