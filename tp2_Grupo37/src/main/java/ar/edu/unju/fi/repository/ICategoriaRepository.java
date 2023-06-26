package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriaRepository extends CrudRepository<Categoria, Long>{
	public List<Categoria> findByEstado(boolean estado);

}
