package ejercicios_avanzados.ejercicios;

import java.util.Random;

import ejercicios_avanzados.clases.BaseDatos;

/* 
 * Crea una clase BaseDatos con un método consultarDatos() que simule la consulta a una base de datos y 
 * lance una excepción en caso de que la conexión a la base de datos falle.

 */
public class Ejercicio55 {
	public static void main(String[] args) {
		// Instanciamos la base de datos y la llenamos de nombres
		BaseDatos database = new BaseDatos();
		database.getListaNombres().add("Víctor");
		database.getListaNombres().add("Hugo");
		database.getListaNombres().add("Alejandro");
		database.getListaNombres().add("Jesús");
		
		// Hacemos un randint, que le enviaremos al método (es el tiempo de espera).
		Random rand = new Random();
		int tiempoEspera = rand.nextInt(10);
		
		// Intentamos recuperar la posición del nombre "Alejandro"
		try {
			int posicion = database.consultarDatos("Alejandro", tiempoEspera);
			System.out.println("El elemento 'Alejandro' se encuentra en la posición " + posicion); 
			// Si el número es menor a 3: El elemento 'Alejandro' se encuentra en la posición 2
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); // Fallo de conexión. Se agotó el tiempo de espera. 

		}
		


	}
}
