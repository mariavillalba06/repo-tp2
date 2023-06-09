package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaDia;
import ar.edu.unju.fi.service.IListaService;

@Service
public class ListaServiceImp implements IListaService{

	@Autowired
	private ListaDia listaDias;
	
	 // retorna la lista de días
	@Override
	public List<String> getDias() {
		return listaDias.getDias();
	}

}
