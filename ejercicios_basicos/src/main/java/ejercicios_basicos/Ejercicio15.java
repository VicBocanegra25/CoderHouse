package ejercicios_basicos;

// Crea una clase Triangulo que tenga atributos base y altura. Agrega un método para calcular el área del triángulo.


public class Ejercicio15 {
	public static void main(String[] args) {
		// Instanciamos la clase
		Triangulo trianguloUno = new Triangulo(5, 12);
		// Calculamos el área
		double areaTrianguloUno = trianguloUno.calcularArea();
		System.out.println("El área del trianguloUno es: " + areaTrianguloUno);
		
		// Le cambiamos los valores al triángulo
		try {
		trianguloUno.setAltura(0);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}

final class Triangulo {
	private double base;
	private double altura; 
	
	
	
	public Triangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}


	public double getBase() {
		return this.base;
	}


	public double getAltura() {
		return this.altura;
	}


	// Los setters lanzan una excepción si se intentan colocar valores menores o iguales a 0
	public void setBase(double base) throws Exception {
		if (base <= 0) {
			throw new Exception("El triángulo debe tener una base menor a 0. "); 
		} else {
		this.base = base;
	}
		}

	public void setAltura(double altura) throws Exception {
		if (altura <= 0) {
			throw new Exception("El triánulo no debe tener una altura menor a 0. "); 
		} else {
		this.altura = altura;
	 }
	}






	public double calcularArea() {
		// Devolvemos el resultado de la (base * altura) / 2
		return (this.base * this.altura) / 2;
	}
}