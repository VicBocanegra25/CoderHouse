package ejercicios_avanzados.ejercicios;

import ejercicios_avanzados.auxiliares.CompararObjetos;
import ejercicios_avanzados.clases.CuentaBancaria;

/* 
 * Define una clase CuentaBancaria con atributos numero y saldo. Implementa los métodos equals() 
 * y hashCode() para comparar dos cuentas bancarias por su número.
 */
public class Ejercicio44 {
	public static void main(String[] args) {
		// Instanciamos dos Cuentas Bancarias
		CuentaBancaria cuentaUno = new CuentaBancaria();
		CuentaBancaria cuentaDos = new CuentaBancaria();
		
		// Les asignamos un número y un saldo
		cuentaUno.setNumeroDeCuenta(4152338129407810l); cuentaUno.setSaldo(38_750.73);
		cuentaDos.setNumeroDeCuenta(4152478963254102l); cuentaUno.setSaldo(175_660.30);
		
		// Las comparamos utilizando la función auxiliar CompararObjetos
		CompararObjetos comparador = new CompararObjetos();
		comparador.compararObjetos(cuentaUno, cuentaDos);

		// Cambiamos el número de cuenta de la cuentaDos y volvemos a imprimir
		cuentaDos.setNumeroDeCuenta(4152338129407810l);
		comparador.compararObjetos(cuentaUno, cuentaDos);

	}
	
}
