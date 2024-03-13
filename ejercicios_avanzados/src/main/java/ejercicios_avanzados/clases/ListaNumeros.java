package ejercicios_avanzados.clases;

import java.util.ArrayList;
import java.util.List;

// Clase correspondiente al ejercicio 53

public class ListaNumeros {
	private List<Integer> listaNumeros = new ArrayList<Integer>();	
	
	

	public List<Integer> getListaNumeros() {
		return listaNumeros;
	}

	public void setListaNumeros(List<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}

	public ListaNumeros() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int buscarNumero(List<Integer> listaDeNumeros, int numeroObjetivo) throws Exception {
		if (listaDeNumeros.indexOf(numeroObjetivo) == -1) {
			throw new Exception("El número "+ numeroObjetivo + " no se encuentra en la lista. ");
		} 
		return listaDeNumeros.indexOf(numeroObjetivo);
	}

	@Override
	public String toString() {
		return "ListaNumeros [listaNumeros=" + listaNumeros + "]";
	}
	
	
	
}
