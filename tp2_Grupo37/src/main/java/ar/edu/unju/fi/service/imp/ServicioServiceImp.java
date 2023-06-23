package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ServicioCorte;
import ar.edu.unju.fi.entity.ServicioPaseo;
//import ar.edu.unju.fi.listas.ListaServicioCorte;
//import ar.edu.unju.fi.listas.ListaServicioPaseo;
import ar.edu.unju.fi.repository.IServicioCorteRepository;
import ar.edu.unju.fi.repository.IServicioPaseoRepository;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service
public class ServicioServiceImp implements IServicioService{

	@Autowired
	ServicioPaseo paseo;
	
	@Autowired
	ServicioCorte corte;
	
	@Autowired
	IServicioCorteRepository servicioCorteRepository;
	
	@Autowired
	IServicioPaseoRepository servicioPaseoRepository;
	
	/* Metodos servicios de paseos */
	/**
	 * Obtiene una lista de todos los servicios de paseos activos.
	 * @return lista de servicios de paseos activos.
	 */
	@Override
	public List<ServicioPaseo> getServicioPaseos() {
		return servicioPaseoRepository.findByEstado(true);
	}
	
	/**
	 * Guarda un nuevo servicio de paseo.
	 * @param paseo objeto de tipo ServicioPaseo a guardar.
	 */
	@Override
	public void guardarPaseo(@Valid ServicioPaseo paseo) {
		paseo.setEstado(true);
		// Agrega el servicioPaseo a la lista de paseos de servicio
		servicioPaseoRepository.save(paseo);
	}

	/**
	 * Obtiene un servicio de paseo por su ID.
	 * @param id del servicio de paseo a buscar.
	 * @return objeto de tipo ServicioPaseo encontrado.
	 */
	@Override
	public ServicioPaseo getByIdPaseo(int id) {
		ServicioPaseo paseoEncontrado = null;
		
		paseoEncontrado = servicioPaseoRepository.findById((long) id).get();
		return paseoEncontrado;
	}

	/**
	 * Modifica un servicio de paseo existente.
	 * @param objeto de tipo ServicioPaseo a modificar.
	 */
	@Override
	public void modificarPaseo(ServicioPaseo paseo) {
		paseo.setEstado(true);
		servicioPaseoRepository.save(paseo);
		
	}

	/**
	 * Elimina un servicio de paseo.
	 * @param objeto de tipo ServicioPaseo a eliminar.
	 */
	@Override
	public void eliminarPaseo(ServicioPaseo paseo) {
		paseo.setEstado(false);
		servicioPaseoRepository.save(paseo);
	}

	/**
	 * Crea un nuevo objeto ServicioPaseo.
	 * @return objeto de tipo ServicioPaseo inicializado.
	 */
	@Override
	public ServicioPaseo nuevoPaseo() {
		return paseo;
	}
	
	/**
	 * Filtra la lista de servicios de paseos por día.
	 * @param día a filtrar.
	 * @return lista de servicios de paseos filtrados por día.
	 */
	@Override
	public List<ServicioPaseo> filtroServicioPaseos(String dia) {
		return servicioPaseoRepository.findByDia(dia);
	}

	
	/* Metodos servicios de cortes*/
	/**
	 * Obtiene una lista de todos los servicios de cortes activos.
	 * @return lista de servicios de cortes activos.
	 */
	@Override
	public List<ServicioCorte> getServicioCortes() {
		return servicioCorteRepository.findByEstado(true);
	}

	/**
	 * Guarda un nuevo servicio de corte.
	 * @param corte objeto de tipo ServicioCorte a guardar.
	 */
	@Override
	public void guardarCorte(@Valid ServicioCorte corte) {
		corte.setEstado(true);
		servicioCorteRepository.save(corte);
	}
	
	/**
	 * Obtiene un servicio de corte por su ID.
	 * @param id del servicio de corte a buscar.
	 * @return objeto de tipo ServicioCorte encontrado.
	 */
	@Override
	public ServicioCorte getByIdCorte(int id) {
		ServicioCorte corteEncontrado = null;
		corteEncontrado = servicioCorteRepository.findById((long) id).get();
		return corteEncontrado;
	}

	/**
	 * Modifica un servicio de corte existente.
	 * @param objeto de tipo ServicioCorte a modificar.
	 */
	@Override
	public void modificarCorte(ServicioCorte corte) {
		
		corte.setEstado(true);
		// Actualiza los datos del corte de servicio en la lista de cortes existentes
		servicioCorteRepository.save(corte);
	}

	/**
	 * Elimina un servicio de corte.
	 * @param objeto de tipo ServicioCorte a eliminar.
	 */
	@Override
	public void eliminarCorte(ServicioCorte corte) {
		//valor booleano para eliminar logicamente el objeto
		corte.setEstado(false);
		servicioCorteRepository.save(corte);
		
	}

	/**
	 * Crea un nuevo objeto ServicioCorte.
	 * @return objeto de tipo ServicioCorte inicializado.
	 */
	@Override
	public ServicioCorte nuevoCorte() {
		return corte;
	}

	/**
	 * Filtra la lista de servicios de cortes por día.
	 * @param dia día a filtrar.
	 * @return lista de servicios de cortes filtrados por día.
	 */
	@Override
	public List<ServicioCorte> filtroServicioCortes(String dia){
		return servicioCorteRepository.findByDia(dia);
	}

}
