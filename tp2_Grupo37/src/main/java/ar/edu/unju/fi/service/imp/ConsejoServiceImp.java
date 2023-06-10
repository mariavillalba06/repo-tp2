package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejosService;
import jakarta.validation.Valid;

@Service
public class ConsejoServiceImp implements IConsejosService{
	@Autowired
	ListaConsejo listaConsejo;
	@Autowired
	private Consejo consejo;
	
	/* Listar Consejos */
	@Override
	public List<Consejo> getConsejos() {
		return listaConsejo.getConsejos();
	}

	/* Obtener un objeto consejo */
	@Override
	public Consejo getConsejo() {
		return consejo;
	}
	
	/* Obtener un objeto consejo */
	@Override
	public Consejo nuevoConsejo() {
		return consejo;
	}
	
	/* Guardar un objeto consejo */
	@Override
	public void guardarConsejo(@Valid Consejo consejo) {
		int ultimaId=0;
		
		for(Consejo ultimoElemento : listaConsejo.getConsejos()) {
			ultimaId = ultimoElemento.getId();
		}
		ultimaId++;
		consejo.setId(ultimaId);
		
		listaConsejo.getConsejos().add(consejo);
	}
	
	/* Buscar objeto consejo a partir de su ID */
	@Override
	public Consejo getByIdConsejo(int id) {
		Consejo consejoEncontrado = null;
		
		for(Consejo consejo: listaConsejo.getConsejos()) {
			if(consejo.getId() == id) {
				consejoEncontrado = consejo;
				break;
			}
		}
		return consejoEncontrado;
	}
	
	/* Modificar un objeto consejo */
	@Override
	public void modificarConsejo(Consejo consejo) {
		for(Consejo c : listaConsejo.getConsejos()) {
			if(c.getId() == consejo.getId()) {
				c.setTitulo(consejo.getTitulo());
				c.setTexto(consejo.getTexto());
				c.setClave(consejo.getClave());
				break;
			}
		}
		
	}
	
	/* Eliminar un objeto consejo a partir de su ID*/
	@Override
	public void eliminarConsejo(int id) {
		for(Consejo c : listaConsejo.getConsejos()) {
			if(c.getId() == id) {
				listaConsejo.getConsejos().remove(c);
				break;
			}
		}
		
	}
	
}
