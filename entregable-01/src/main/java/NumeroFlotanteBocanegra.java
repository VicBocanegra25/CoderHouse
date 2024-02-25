
public class NumeroFlotanteBocanegra {

	public static void main(String[] args) {
		/*
		 * El propósito de este script es crear un método main que permita mostrar la parte entera de un número y separar la parte decimal de un tipo de dato float. 
		 * Agregando git.
		 */
        // Definimos la variable pi como un número de tipo float. 
        float pi = 3.1416F;

        // Definimos una variable para almacenar la parte entera de pi
        int parteEntera = (int) pi;

        // Definimos una variable para almacenar la parte decimal
        float parteDecimal = pi - parteEntera;

        // Imprimimos ambas variables 
        System.out.println("Este programa muestra la parte entera y la parte decimal del número pi (hasta 4 decimales)");
        System.out.println("La parte entera de pi es: " + parteEntera);
        System.out.println("La parte decimal de pi es: " + parteDecimal);

		
	}

}
