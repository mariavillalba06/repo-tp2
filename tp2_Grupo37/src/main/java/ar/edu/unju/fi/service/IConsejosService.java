package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

public interface IConsejosService {
	List<Consejo> getConsejos();
	
	Consejo getConsejo();
	
	Consejo nuevoConsejo();
	
	void guardarConsejo(@Valid Consejo consejo);
	
	Consejo getByIdConsejo(int id);
	
	void modificarConsejo(Consejo consejo);
	
	void eliminarConsejo(int id);
}
