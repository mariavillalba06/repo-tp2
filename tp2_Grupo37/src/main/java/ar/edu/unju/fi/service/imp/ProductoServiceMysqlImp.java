package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;
@Service("productoServiceMysql")

public class ProductoServiceMysqlImp implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private Producto producto;

	@Override
	public List<Producto> getLista() {
		return productoRepository.findByEstado(true);
	}

	@Override
	public void guardarse(@Valid Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);

	}

	@Override
	public Producto getBy(Long id) {
		producto = productoRepository.findById(id).get();
		return producto;
	}

	@Override
	public void modificarse(Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);

	}

	@Override
	public void eliminarse(Producto producto) {
		producto.setEstado(false);
		productoRepository.save(producto);

	}

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return new Producto();
	}

}
