package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.Empleado;

/* 
 * Crea una clase Empleado con atributos nombre, departamento y salario. Implementa los métodos equals() y hashCode() 
 * para comparar dos empleados por su nombre y departamento.

 */
public class Ejercicio47 {
	public static void main(String[] args) {
		// Instanciamos tres Empleados
		Empleado empleadoUno = new Empleado("Víctor", "IT", 53_000d);
		Empleado empleadoDos = new Empleado("Víctor", "IT", 35_000d);
		Empleado empleadoTres = new Empleado("Víctor", "HR", 35_000d);
		
		// Comparamos los objetos entre sí
		CompararObjetos comparador = new CompararObjetos();
		comparador.compararObjetos(empleadoUno, empleadoDos);
		comparador.compararObjetos(empleadoUno, empleadoTres);
		comparador.compararObjetos(empleadoDos, empleadoTres);
		
		
	}
}
