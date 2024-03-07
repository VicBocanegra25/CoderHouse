package com.coderhouse.clases;

// Esta clase sirve para instanciar objetos de la clase Vehiculos
public class TestVehiculos2 {
	public static void main(String[] args) {
		
		// Generamos dos instancias de la clase
		Vehiculos auto = new Vehiculos();
		Vehiculos moto = new Vehiculos();
		
		// Imprimimos las propiedades de los vehículos
		System.out.println(auto); // Sin el override a toString, nos da esta dirección de memoria: com.coderhouse.clases.Vehiculos@7ad041f3
		
		/// Asignamos atributos a la clase
		auto.setCantidadDeRuedas(4);
		auto.setMarca("Ford");
		auto.setColor("Azul");
		auto.setPrecio(2000);
		auto.setEsElectrico(false);
		
		// Volvemos a imrpimir el objeto, con sus propiedades. 
		System.out.println(auto);
		
		// Llamamos uno de los métodos - encender()
		auto.encender();
		auto.encender();
	}

}
