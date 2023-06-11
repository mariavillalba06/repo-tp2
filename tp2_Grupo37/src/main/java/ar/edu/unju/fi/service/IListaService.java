package ar.edu.unju.fi.service;

import java.util.List;

public interface IListaService {
	
	/**
	 * Obtiene una lista de días.
	 *
	 * @return regresa una la lista de días
	 */
	List<String> getDias();
	
	/**
	 * Obtiene una lista de categorias.
	 *
	 * @return regresa una la lista de categorias
	 */
	List<String> getCategorias();
	
	/**
	 * Obtiene una lista de provincias.
	 *
	 * @return regresa una la lista de provincias
	 */
	List<String> getProvincias();
}
