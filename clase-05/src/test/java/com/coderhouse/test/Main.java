package com.coderhouse.test;


import com.coderhouse.clases.Perro;

public class Main {
	
	public static void main(String[] args) {
		
		// Generando una instancia de perro
		Perro unPerro = new Perro(); 
		Perro otroPerro = new Perro();
		
		unPerro.setClase("Mamífero");
		unPerro.setColor("Blanco");
		unPerro.setExtinto(false);
		unPerro.setGenero("Macho");
		unPerro.setEdad(13);
		unPerro.setNombre("Velkan");
		unPerro.setRaza("Husky");
		
		otroPerro.setClase("Mamífero");
		otroPerro.setColor("Blanco");
		otroPerro.setExtinto(false);
		otroPerro.setGenero("Macho");
		otroPerro.setEdad(13);
		otroPerro.setNombre("Velky");
		otroPerro.setRaza("Husky");

//		System.out.println("Un perro: " + unPerro);
//		unPerro.comer();

		System.out.println("HashCode de unPerro = " + unPerro.hashCode());
		System.out.println("HashCode de otroPerro = " + otroPerro.hashCode());

		System.out.println("unPerro.equals(otroPerro) : " + unPerro.equals(otroPerro));
		System.out.println("unPerro == otroPerro : " + (unPerro == otroPerro));
		
		// Se genera una nueva instancia de Perro
		Perro unTercerPerro = new Perro("Perro", false, null, "negro", "Coder", null, null);
		System.out.println("unTercerPerro" + unTercerPerro);
		
	}
		
}

//public static void main(String[] args) {
//Animal unAnimal = new Animal(); 
//Animal otroAnimal = new Animal(); 
//
//// Definimos propiedades del animal
//unAnimal.setClase("Mamífero");
//unAnimal.setExtinto(false);
//unAnimal.setGenero("Macho");
//unAnimal.setEdad(5);
//unAnimal.comer();
//unAnimal.dormir(); 
//unAnimal.andar();
//
//// Ahora definimos la otra clase, con las mismas propiedades
//otroAnimal.setClase("Mamífero");
//otroAnimal.setExtinto(false);
//otroAnimal.setGenero("Macho");
//otroAnimal.setEdad(5);
//otroAnimal.comer();
//otroAnimal.dormir(); 
//otroAnimal.andar();
//
//System.out.println("UnAnimal " + unAnimal);
//System.out.println("UnAnimal " + otroAnimal);
//