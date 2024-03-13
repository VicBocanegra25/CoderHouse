package ejercicios_avanzados.clases;

import java.util.ArrayList;
import java.util.List;

// Esta clase corresponde al ejercicio 55
public class BaseDatos {
	// La base de datos contiene una lista de nombres
	private List<String> listaNombres = new ArrayList<String>();
	
	// Getters y Setters
	public List<String> getListaNombres() {
		return listaNombres;
	}


	public void setListaNombres(List<String> listaNombres) {
		this.listaNombres = listaNombres;
	}


	public BaseDatos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int consultarDatos(String elemento, int tiempoConsulta) throws Exception {
		// El método devuelve la posición del elemento enviado como parámetro, pero sólo si el tiempo de consulta es menor a 3 seg.
		if (tiempoConsulta < 3) {
			throw new Exception("Fallo de conexión. Se agotó el tiempo de espera. ");
		}
		return getListaNombres().indexOf(elemento);
	}
	

}
