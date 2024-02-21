package com.coderhouse;

public class incrementos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int miNumero = 0;
		System.out.println("El valor de mi número es: " + miNumero);
		// Incrementando el valor de la variable en una unidad. 
		miNumero++;

		miNumero = miNumero + 2;
		System.out.println("El valor de mi número es: " + miNumero);
		
		// Pre incremento
		int miNumeroPre = 0;

		System.out.println("El valor de mi número es: " + miNumeroPre);
		++miNumeroPre;

		System.out.println("El valor de mi número es: " + miNumeroPre);
		
		int x = 0;
		x++;
		System.out.println("El valor de x de Post es: " + x);
		++x;
		System.out.println("El valor de x de Pre es: " + x);

		// Ahora se muestra un ejemplo donde pre y posfix no dan el mismo resultado: 
        int x1 = 5;
        int y = 5;

        // Postfix increment
        int result1 = x1++;
        // At this point, 'x' is 6, but 'result1' is 5 because 'x' gets incremented after its value is assigned to 'result1'.

        // Prefix increment
        int result2 = ++y;
        // At this point, 'y' is 6, and 'result2' is also 6 because 'y' gets incremented before its value is assigned to 'result2'.



		
	}

}
