package ejercicios_avanzados.auxiliares;

// La clase implementa un método que sirve para comparar dos Objetos

public class CompararObjetos {
	// Implementamos un método genérico para comparar dos objetos del mismo tipo
	public static <T> void compararObjetos(T objetoUno, T objetoDos) {
		if (objetoUno.equals(objetoDos)) {
            System.out.println("Los objetos son iguales.");
		} else {
            System.out.println("Los objetos son distintos.");
		}
	}
}
