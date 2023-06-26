package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;

@Service
public class CategoriaServiceImp implements ICategoriaService{

	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@Autowired
	private Categoria categoria;
	
	@Override
	public void guardarCategoria(Categoria categoria) {
		categoria.setEstado(true);
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> getListaCategorias() {
		return categoriaRepository.findByEstado(true);
	}

	@Override
	public Categoria findCategoriaById(Long id) {
		categoria = categoriaRepository.findById(id).get();
		return categoria;
	}

	@Override
	public void eliminarCategoria(Categoria categoria) {
		categoria.setEstado(false);
		categoriaRepository.save(categoria);
	}

	@Override
	public void modificarCategoria(Categoria categoria) {
		categoria.setEstado(true);
		categoriaRepository.save(categoria);
	}

	@Override
	public Categoria nuevaCategoria() {
		return new Categoria();
	}

}
