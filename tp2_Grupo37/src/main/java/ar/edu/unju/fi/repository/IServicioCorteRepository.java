package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.ServicioCorte;

public interface IServicioCorteRepository extends CrudRepository<ServicioCorte, Long>{
	/**
	Recupera una lista de ServicioCorte basada en el estado verdadero.
	@param estado, variable de estado para filtrar las entidades.
	@return retorna una lista de ServicioCorte que coinciden con el estado verdadero.
	*/
	public List<ServicioCorte> findByEstado(boolean estado);
	
	/**

	Recupera una lista de ServicioCorte basada en el día especificado.
	@param dia, variable de día para filtrar las entidades.
	@return retorna una lista de ServicioCorte que coinciden con el día especificado.
	*/
	List<ServicioCorte> findByDia(String dia);
}
