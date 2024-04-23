package ejercicios;

import clases.Camioneta;
import clases.Coche;
import clases.Moto;

/* 
 *  Crea una clase Vehiculo con atributos como marca, modelo, y métodos como acelerar() y
 *  frenar(). Luego, crea subclases como Coche, Moto, y Camioneta que hereden de Vehiculo e 
 *  implementa métodos específicos para cada tipo de vehículo.
 */
public class Ejercicio1 {
	public static void main(String[] args) {
		// Instanciamos el auto, la moto y la camioneta
		Coche coche = new Coche();
		coche.setMarca("Ford");
		coche.setModelo("Mustang");
		
		Moto moto = new Moto("Harley-Davidson", "Road King Special");
		
		Camioneta camioneta = new Camioneta("Tesla", "Cybertruck");
		
		// Llamamos los métodos en común
		coche.acelerar(); coche.frenar();
		moto.acelerar(); moto.frenar();
		camioneta.acelerar(); camioneta.frenar();
		
		// Llamamos los métodos propios de las clases
		coche.activarDescapotable(); coche.desactivarDescapotable();
		moto.hacerCaballito(); moto.quemarNeumatico();
		camioneta.activarOverdrive(); camioneta.desactivarOverdrive();
		
		
	}
	
}
