package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ServicioCorte;
import ar.edu.unju.fi.entity.ServicioPaseo;
import jakarta.validation.Valid;

public interface IServicioService {
	
	/* Metodos servicios de paseos */
	List<ServicioPaseo> getServicioPaseos();
	
	void guardarPaseo(@Valid ServicioPaseo paseo);
	
	ServicioPaseo getByIdPaseo(int id);
	
	void modificarPaseo(ServicioPaseo paseo);
	
	void eliminarPaseo(ServicioPaseo paseo);
	
	ServicioPaseo nuevoPaseo();
	
	List<ServicioPaseo> filtroServicioPaseos(String dia);
	
	/* Metodos servicios de cortes*/
	List<ServicioCorte> getServicioCortes();
	
	void guardarCorte(@Valid ServicioCorte corte);
	
	ServicioCorte getByIdCorte(int id);
	
	void modificarCorte(ServicioCorte corte);
	
	void eliminarCorte(ServicioCorte corte);
	
	ServicioCorte nuevoCorte();
	
	List<ServicioCorte> filtroServicioCortes(String dia);
}
