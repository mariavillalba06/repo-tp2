package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriaService {
	
	public void guardarCategoria(Categoria categoria);
	 
	public List<Categoria> getListaCategorias();
	
	public Categoria findCategoriaById(Long id);
	
	public void eliminarCategoria(Categoria categoria);
	
	void modificarCategoria(Categoria categoria);

	public Categoria nuevaCategoria();
}

