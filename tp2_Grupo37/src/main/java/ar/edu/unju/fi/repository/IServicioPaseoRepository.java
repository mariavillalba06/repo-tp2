package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.ServicioPaseo;

public interface IServicioPaseoRepository extends CrudRepository<ServicioPaseo, Long>{
	/**
	 * Recupera una lista de ServicioPaseo basada en el estado especificado.
	 *
	 * @param estado, valor de estado para filtrar las entidades.
	 * @return retorna una lista de ServicioPaseo que coinciden con el estado especificado.
	 */
	public List<ServicioPaseo> findByEstado(boolean estado);

	/**
	 * Recupera una lista de ServicioPaseo basada en el día especificado.
	 *
	 * @param dia, valor de día para filtrar las entidades.
	 * @return retorna una lista de ServicioPaseo que coinciden con el día especificado.
	 */
	public List<ServicioPaseo> findByDia(String dia);

}
