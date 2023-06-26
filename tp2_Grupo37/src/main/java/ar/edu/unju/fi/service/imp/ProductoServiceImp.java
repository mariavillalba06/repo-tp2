package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;


@Service
public class ProductoServiceImp implements IProductoService{

	
	@Autowired
	private IProductoRepository productoRespository;
	
	@Autowired
	private Producto producto;
	
	//Listar Productos
	@Override
	public List<Producto> getLista() {
		return productoRespository.findByEstado(true);
	}

	//Guardar un objeto producto
	@Override
	public void guardarse(@Valid Producto producto) {
		int numeroImagen;
		Random random = new Random();
		numeroImagen = random.nextInt(3) + 1;
		producto.setNumeroImg(numeroImagen);
		producto.setPrecioTotal(producto.calcularDescuento());
		producto.setEstado(true);
		productoRespository.save(producto);
		
	}
	
	//Buscar objeto producto a partir de su codigo
	@Override
	public Producto getBy(Long id) {
		producto = productoRespository.findById(id).get();
		return producto;
	}

	//Modificar un objeto producto
	@Override
	public void modificarse(Producto producto) {
		int numeroImagen;
		Random random = new Random();
		numeroImagen = random.nextInt(3) + 1;
		producto.setNumeroImg(numeroImagen);
		producto.setNumeroImg(numeroImagen);
		producto.setPrecioTotal(producto.calcularDescuento());
		producto.setEstado(true);
		productoRespository.save(producto);
	}
	
	//Eliminar un objeto producto
	@Override
	public void eliminarse(Producto productoEncontrado) {
		productoEncontrado.setEstado(false);
		productoRespository.save(productoEncontrado);
	}

	// Obtener un objeto producto 
	@Override
	public Producto getProducto() {
		return new Producto();
	}

}
