package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

public interface IConsejosService {
	/* Listar Consejos */
	List<Consejo> getConsejos();
	
	/* Obtener un objeto consejo */
	Consejo getConsejo();
	
	/* Obtener un objeto consejo */
	Consejo nuevoConsejo();
	
	/* Guardar un objeto consejo */
	void guardarConsejo(@Valid Consejo consejo);
	
	/* Buscar objeto consejo a partir de su ID */
	Consejo getByIdConsejo(int id);
	
	/* Modificar un objeto consejo */
	void modificarConsejo(Consejo consejo);
	
	/* Eliminar un objeto consejo a partir de su ID*/
	void eliminarConsejo(int id);
}
