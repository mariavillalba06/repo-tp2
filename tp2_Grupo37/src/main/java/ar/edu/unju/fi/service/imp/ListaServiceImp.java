package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaCategoria;
import ar.edu.unju.fi.listas.ListaDia;
import ar.edu.unju.fi.listas.ListaProvincia;
import ar.edu.unju.fi.service.IListaService;

@Service
public class ListaServiceImp implements IListaService{

	@Autowired
	private ListaDia listaDias;
	
	@Autowired
	private ListaCategoria listaCategorias;
	
	@Autowired
	private ListaProvincia listaProvincias;
	
	 // retorna la lista de días
	@Override
	public List<String> getDias() {
		return listaDias.getDias();
	}
	
	// retorna la lista de categorias
	@Override
	public List<String> getCategorias() {
		return listaCategorias.getCategorias();
	}

	@Override
	public List<String> getProvincias() {
		return listaProvincias.getProvincias();
	}

}
