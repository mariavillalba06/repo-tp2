package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;


@Service
public class ProductoServiceImp implements IProductoService{

	@Autowired
	private ListaProducto listaProducto;
	@Autowired
	private Producto producto;
	
	//Listar Productos
	@Override
	public List<Producto> getLista() {
		return listaProducto.getProductos();
	}

	//Guardar un objeto producto
	@Override
	public void guardarse(@Valid Producto producto) {
		int ultimaId=0, numeroImagen;
		for(Producto ultimoElemento : listaProducto.getProductos()) {
			ultimaId = ultimoElemento.getCodigo();
		}
		ultimaId++;
		producto.setPrecioTotal(producto.calcularDescuento());
		producto.setCodigo(ultimaId);
		Random random = new Random();
		numeroImagen = random.nextInt(3) + 1;
		producto.setNumeroImg(numeroImagen);
		
		listaProducto.getProductos().add(producto);
		
	}
	
	//Buscar objeto producto a partir de su codigo
	@Override
	public Producto getBy(int codigo) {
		Producto productoEncontrado=null;
		for(Producto produ : listaProducto.getProductos()) {
			if(produ.getCodigo() == codigo) {
				productoEncontrado=produ;
				break;
			}
		}
		return productoEncontrado;
	}

	//Modificar un objeto producto
	@Override
	public void modificarse(Producto producto) {
		for(Producto produ: listaProducto.getProductos()) {
			if(produ.getCodigo() == producto.getCodigo()) {
				produ.setNombre(producto.getNombre());
				produ.setCategoria(producto.getCategoria());
				produ.setDescuento(producto.getDescuento());
				produ.setPrecio(producto.getPrecio());
				produ.setPrecioTotal(producto.calcularDescuento());
				break;
				}
		}	
		
	}
	
	//Eliminar un objeto producto
	@Override
	public void eliminarse(Producto productoEncontrado) {
		listaProducto.getProductos().remove(producto);
		
	}

	// Obtener un objeto producto 
	@Override
	public Producto getProducto() {
		return producto;
	}

}
