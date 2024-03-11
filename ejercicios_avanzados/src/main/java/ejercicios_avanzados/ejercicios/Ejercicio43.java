package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.clases.Producto;
import ejercicios_avanzados.clases.producto;

/* 
 * Crea una clase Producto con atributos nombre, precio y codigo. 
 * Implementa los métodos equals() y hashCode() para comparar dos productos por su código.
 */
public class Ejercicio43 {
	public static void main(String[] args) {
		// Instanciamos los productos
		Producto productoUno = new Producto();
		Producto productoDos = new Producto();
		
		// Utilizamos los setters para darles nombre y precio iguales, pero código distinto
		productoUno.setNombreProducto("Café Soluble - Nescafé");
		productoDos.setNombreProducto("Café Soluble - Nescafé");
		productoUno.setPrecio(110);
		productoDos.setPrecio(110);
		productoUno.setCodigo(7501058620101l);
		productoDos.setCodigo(1010268501057l);
	
		// Comparamos los productos
		compararProduc(productoUno, productoDos);
	}
	
	// Método auxiliar que sirve para comparar dos objetos del tipo producto
	public static void compararProduc(Producto productoUno_, Producto productoDos_) {
		if (productoUno_.equals(productoDos_)) {
			System.out.println("Los Productos son iguales. ");
		} else {
			System.out.println("Los Productos son distintas. ");
		}
	}
}
