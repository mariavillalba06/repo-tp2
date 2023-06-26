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
	
	/*
	 * Mantendra el numero de imagen en caso de modificar un producto
	 * Si el producto de crea el numero sera aleatorio
	 */
	//private int numeroImagen;
	
	//Listar Productos
	@Override
	public List<Producto> getLista() {
		//return listaProducto.getProductos();
		return productoRespository.findByEstado(true);
	}

	//Guardar un objeto producto
	@Override
	public void guardarse(@Valid Producto producto) {
		int numeroImagen;
		/*int ultimaId=0, numeroImagen;
		for(Producto ultimoElemento : listaProducto.getProductos()) {
			ultimaId = ultimoElemento.getCodigo();
		}
		ultimaId++;
		producto.setPrecioTotal(producto.calcularDescuento());
		producto.setCodigo(ultimaId);
		Random random = new Random();
		numeroImagen = random.nextInt(3) + 1;
		producto.setNumeroImg(numeroImagen);
		
		listaProducto.getProductos().add(producto);*/
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
		/*Producto productoEncontrado=null;
		for(Producto produ : listaProducto.getProductos()) {
			if(produ.getCodigo() == id) {
				productoEncontrado=produ;
				break;
			}
		}
		return productoEncontrado;*/
		producto = productoRespository.findById(id).get();
		return producto;
	}

	//Modificar un objeto producto
	@Override
	public void modificarse(Producto producto) {
		int numeroImagen;
		/*for(Producto produ: listaProducto.getProductos()) {
			if(produ.getCodigo() == producto.getCodigo()) {
				produ.setNombre(producto.getNombre());
				//produ.setCategoria(producto.getCategoria());
				produ.setDescuento(producto.getDescuento());
				produ.setPrecio(producto.getPrecio());
				produ.setPrecioTotal(producto.calcularDescuento());
				break;
				}
		}*/
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
		//listaProducto.getProductos().remove(producto);
		productoEncontrado.setEstado(false);
		productoRespository.save(productoEncontrado);
	}

	// Obtener un objeto producto 
	@Override
	public Producto getProducto() {
		return new Producto();
	}

}
