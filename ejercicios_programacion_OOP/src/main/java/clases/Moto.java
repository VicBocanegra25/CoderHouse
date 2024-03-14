package clases;

public class Moto extends Vehiculo {
	
	// Constructors
	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moto(String marca, String modelo) {
		super(marca, modelo);
		// TODO Auto-generated constructor stub
	}

	// Métodos propios de una Moto
	public void hacerCaballito() {
		System.out.println("Se realiza la acrobacia del caballito. ");
	}
	
	public void quemarNeumatico() {
		System.out.println("Se realiza la acrobacia de quemar el neumático. ");
	}
}
