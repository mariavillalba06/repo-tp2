package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.ServicioCorte;
import ar.edu.unju.fi.model.ServicioPaseo;
import jakarta.validation.Valid;

public interface IServicioService {
	
	/* Metodos servicios de paseos */
	List<ServicioPaseo> getServicioPaseos();
	
	void guardarPaseo(@Valid ServicioPaseo paseo);
	
	ServicioPaseo getByIdPaseo(int id);
	
	void modificarPaseo(ServicioPaseo paseo);
	
	void eliminarPaseo(int id);
	
	ServicioPaseo nuevoPaseo();
	
	/* Metodos servicios de cortes*/
	List<ServicioCorte> getServicioCortes();
	
	void guardarCorte(@Valid ServicioCorte corte);
	
	ServicioCorte getByIdCorte(int id);
	
	void modificarCorte(ServicioCorte corte);
	
	void eliminarCorte(int id);
	
	ServicioCorte nuevoCorte();
}
