package com.coderhouse;

public class EjemploConSwitch {

	public static void main(String[] args) {
		int diaDeLaSemana = 4;
		String nombreDelDia;
		
		// Evaluando el día de la semana con un switch - case
		
	switch(diaDeLaSemana) {
	case 1: nombreDelDia = "Domingo";
	break;
	case 2: nombreDelDia = "Lunes";
	break;
	case 3: nombreDelDia = "Martes";
	break;
	case 4: nombreDelDia = "Miércoles";
	break;
	case 5: nombreDelDia = "Jueves";
	break;
	case 6: nombreDelDia = "Viernes";
	break;
	case 7: nombreDelDia = "Sábado";
	break;
	default:
		nombreDelDia = "No existe ese día";
	
	}
	
	System.out.println("El nombre del día es: " + nombreDelDia);
		
	}

}
