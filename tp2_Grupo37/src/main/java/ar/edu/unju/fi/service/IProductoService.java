package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

public interface IProductoService {
	//lista de productos
	List<Producto> getLista();
	
	//Guardar un objeto producto
	void guardarse(@Valid Producto producto);
	
	//Buscar un producto por su codigo
	Producto getBy(int codigo);
	
	//Modificar un objeto producto
	void modificarse(Producto producto);
	
	//Eliminar un objeto producto
	void eliminarse(Producto productoEncontrado);
	
	//Obtener un onjeto producto
	Producto getProducto();
}
