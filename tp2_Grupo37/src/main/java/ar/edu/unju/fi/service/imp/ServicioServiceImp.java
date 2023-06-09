package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicioCorte;
import ar.edu.unju.fi.listas.ListaServicioPaseo;
import ar.edu.unju.fi.model.ServicioCorte;
import ar.edu.unju.fi.model.ServicioPaseo;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	ListaServicioPaseo servicioPaseos;
	
	@Autowired
	ListaServicioCorte servicioCortes;
	
	@Autowired
	ServicioPaseo paseo;
	
	@Autowired
	ServicioCorte corte;
	
	/* Metodos servicios de paseos */
	@Override
	public List<ServicioPaseo> getServicioPaseos() {
		return servicioPaseos.getServicioPaseos();
	}

	@Override
	public void guardarPaseo(@Valid ServicioPaseo paseo) {
		//valor utilizado para controlar el valor del ultima ID, se inicializa en 0 en caso de estar vacia
		int ultimaId=0;
		
		//Se posiciona en el ultimo elemento y obtine su ID e incrementarlo una unidad
		for(ServicioPaseo ultimoElemento : servicioPaseos.getServicioPaseos()) {
			ultimaId = ultimoElemento.getId();
		}
		
		ultimaId++;
		paseo.setId(ultimaId);
		
		// Agrega el servicioPaseo a la lista de paseos de servicio
		servicioPaseos.getServicioPaseos().add(paseo);		
	}

	@Override
	public ServicioPaseo getByIdPaseo(int id) {
		ServicioPaseo paseoEncontrado = null;
		
		// Busca el paseo de servicio correspondiente al ID proporcionado
		for(ServicioPaseo paseo: servicioPaseos.getServicioPaseos()) {
			if(paseo.getId() == id) {
				paseoEncontrado = paseo;
				break;
			}
		}
		return paseoEncontrado;
	}

	@Override
	public void modificarPaseo(ServicioPaseo paseo) {
		// Recorre la lista de paseos de servicio para encontrar el objeto correspondiente al ID
		for(ServicioPaseo paseoModificado: servicioPaseos.getServicioPaseos()) {
			if(paseoModificado.getId() == paseo.getId()) {
				// Actualiza los atributos del paseo con los valores del objeto servicioPaseo
				paseoModificado.setNombre(paseo.getNombre());
				paseoModificado.setDia(paseo.getDia());
				paseoModificado.setHorarioInicio(paseo.getHorarioInicio());
				paseoModificado.setHorarioFinal(paseo.getHorarioFinal());
				break;
			}
		}
		
	}

	@Override
	public void eliminarPaseo(int id) {
		// Recorre la lista de paseos de servicio para encontrar el objeto correspondiente al ID
		for(ServicioPaseo paseo : servicioPaseos.getServicioPaseos()) {
			// Elimina el paseo de la lista de paseos de servicio
			if(paseo.getId() == id) {
				// Elimina el paseo de la lista de paseos de servicio
				servicioPaseos.getServicioPaseos().remove(paseo);
				break;
			}
		}
	}

	@Override
	public ServicioPaseo nuevoPaseo() {
		return paseo;
	}

	
	/* Metodos servicios de cortes*/
	@Override
	public List<ServicioCorte> getServicioCortes() {
		return servicioCortes.getServicioCortes();
	}


	@Override
	public void guardarCorte(@Valid ServicioCorte corte) {
		//valor utilizado para controlar el valor del ultima ID, se inicializa en 0 en caso de estar vacia
		int ultimaId=0;
		
		//Se posiciona en el ultimo elemento y obtine su ID e incrementarlo una unidad
		for(ServicioCorte ultimoElemento : servicioCortes.getServicioCortes()){
			ultimaId = ultimoElemento.getId();
		}
		ultimaId++;
		
		// Establece el ID incrementado al objeto
		corte.setId(ultimaId);
		// Agrega el servicioCorte a la lista de cortes
		servicioCortes.getServicioCortes().add(corte);
	}
	
	@Override
	public ServicioCorte getByIdCorte(int id) {
		ServicioCorte corteEncontrado = null;
		// Recorre la lista de cortes de servicio para encontrar el objeto correspondiente al ID
		for(ServicioCorte corte: servicioCortes.getServicioCortes()) {
			if(corte.getId() == id) {
				corteEncontrado = corte;
				break;
			}
		}
		return corteEncontrado;
	}

	@Override
	public void modificarCorte(ServicioCorte corte) {
		// Actualiza los datos del corte de servicio en la lista de cortes existentes
		for(ServicioCorte corteModificado: servicioCortes.getServicioCortes()) {
			if(corteModificado.getId() == corte.getId()) {
				corteModificado.setInstrumento(corte.getInstrumento());
				corteModificado.setPesoMaximo(corte.getPesoMaximo());
				corteModificado.setPesoMinimo(corte.getPesoMinimo());
				corteModificado.setPrecio(corte.getPrecio());
				break;
			}
		}
	}

	@Override
	public void eliminarCorte(int id) {
		// Busca el corte de servicio correspondiente al ID y lo elimina de la lista
		for(ServicioCorte corte : servicioCortes.getServicioCortes()) {
			if(corte.getId() == id) {
				servicioCortes.getServicioCortes().remove(corte);
				break;
			}
		}
	}

	@Override
	public ServicioCorte nuevoCorte() {
		return corte;
	}

}
