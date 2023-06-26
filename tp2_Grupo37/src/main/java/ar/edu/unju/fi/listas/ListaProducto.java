package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

import java.util.ArrayList;
import ar.edu.unju.fi.entity.Categoria;

@Component
public class ListaProducto {
	private List<Producto> productos;
	
	/**
     * Constructor de la clase ListaProducto
     * Permite inicializar la lista de productos con algunos bojetos percargados
     */ 
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		
	}

	/**
     * Retorna la lista de Productos
     */
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}