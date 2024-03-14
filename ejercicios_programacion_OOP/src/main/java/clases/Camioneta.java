package clases;

public class Camioneta extends Vehiculo {

	public Camioneta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camioneta(String marca, String modelo) {
		super(marca, modelo);
		// TODO Auto-generated constructor stub
	}
	
	// Métodos únicos de la camioneta
	public void activarOverdrive() {
		System.out.println("Se ha activado la sobre marcha. ");
	}
	public void desactivarOverdrive() {
		System.out.println("Se ha desactivado la sobre marcha. ");
	}
	
}
