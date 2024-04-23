package ejercicios_basicos;

/* 
 * Declara un array de cadenas de tamaño 4, inicialízalo con nombres y 
 * luego imprime cada elemento del array en una línea separada.
 */
public class Ejercicio14 {

	public static void main(String[] args) {
		// Declaramos el array de Strings
		String [] nombres = {
				"Alejandro",
				"Victor",
				"Max",
				"Luis"
		}; 
		
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
		
		// Declaramos un nuevo array, pero limitado a 4
		String [] nombres2 = new String[4];
		nombres2 [0] = "Alejandro";
		nombres2 [1] = "Victor";
		nombres2 [2] = "Max";
		nombres2 [3] = "Luis";
		
		for (int i = 0; i < nombres2.length; i++) {
			System.out.println(nombres2[i]);			
		}
	}
	
}
