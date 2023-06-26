package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long>{
	
	/**
	Recupera una lista de Productos basada en el estado verdadero.
	@param estado, variable de estado para filtrar las entidades.
	@return retorna una lista de Productos que coinciden con el estado verdadero.
	*/
	public List<Producto> findByEstado(boolean estado);

}
