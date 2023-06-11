package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaProvincia {
	private List<String> provincias;
	
	/**
	 * Constructor por defecto donde inicializa la lista con las provincias
	 */
	public ListaProvincia() {
		provincias = new ArrayList<String>();
		provincias.add("Buenos aires");
		provincias.add("Catamarca");
		provincias.add("Jujuy");
		provincias.add("Salta");
		provincias.add("Tucumán");
	}
	
	/**
	 * Obtiene la lista de las provincias.
	 *
	 * @return la lista de las provincias.
	 */
	public List<String> getProvincias(){
		return provincias;
	}
	
	public void setProvincias(List<String> provincias) {
		this.provincias = provincias;
	}
}


