package com.coderhouse.clases;

public class Edificio {
	
	private static final int CANTIDAD_MAXIMA_PISOS = 40;
	private int cantidadDePisos;

	public int getCantidadDePisos() {
		return cantidadDePisos;
	}

	// Restringimos la cantidad de pisos
	public void setCantidadDePisos(int cantidadDePisos) throws Exception {
		String mensajeError = "Un edificio no puede tener más de + " + CANTIDAD_MAXIMA_PISOS + " pisos";
		// Se implementa la lógica de la validación
		if (cantidadDePisos > CANTIDAD_MAXIMA_PISOS) {
			throw new Exception(mensajeError);
		} else {
			this.cantidadDePisos = cantidadDePisos;	
		}

	}
	
	public static void main(String[] args) {
		// Instanciamos el edificio
		Edificio primerEdificio = new Edificio();
		Edificio segundoEdificio = new Edificio();
		try {
		// Colocamos la cantidad de pisos utilizando el setter
		primerEdificio.setCantidadDePisos(3);
		segundoEdificio.setCantidadDePisos(10);
		
		// Llamamos los getters
		System.out.println("Cantidad de pisos del primer edificio " + primerEdificio.getCantidadDePisos());
		System.out.println("Cantidad de pisos del segundo edificio " + segundoEdificio.getCantidadDePisos());		
		} catch (Exception exception) {
			exception.printStackTrace();
			
		}
		}
}

