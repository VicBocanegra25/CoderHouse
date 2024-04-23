package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Perro;

/* 
 * Define una subclase llamada Perro que herede de la clase Animal y 
 * tenga un atributo adicional raza. Crea un objeto de tipo Perro e imprime su nombre y raza.
 */
public class Ejercicio37 {
	public static void main(String[] args) {
		// Instanciamos la clase Perro
		Perro unPerro = new Perro("Velkan", "Huski");
		// Utilizamos el setter, ya que nos equivocamos al momento de construir el objeto
		unPerro.setRaza("Husky");
		// Imprimimos el nombre y la raza, pero haciendo uso del método toString
		System.out.println(unPerro);
		
		
	}
}
