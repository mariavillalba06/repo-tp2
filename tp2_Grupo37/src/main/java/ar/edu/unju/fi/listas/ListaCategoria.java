package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaCategoria {
	
	private List<String> categorias;
	
	/**
	 * Constructor por defecto donde inicializa la lista con las categorias
	 */
	public ListaCategoria() {
		categorias = new ArrayList<String>();
		categorias.add("Alimentos");
		categorias.add("Accesorios");
		categorias.add("Camas");
		categorias.add("Juguetes");
		categorias.add("Productos");
		categorias.add("Vestimenta");
	}
	
	/**
	 * Obtiene la lista de las categorias
	 *
	 * @return la lista de las categorias
	 */
	public List<String> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
}

