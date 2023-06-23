package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

import java.util.ArrayList;

@Component
public class ListaProducto {
	private List<Producto> productos;
	
	/**
     * Constructor de la clase ListaProducto
     * Permite inicializar la lista de productos con algunos bojetos percargados
     */ 
	
	public ListaProducto() {
		Producto producto1 = new Producto(1,"arena para gatos",1,189,"Productos",0);
		producto1.setPrecioTotal(producto1.calcularDescuento());
		Producto producto2 = new Producto(2,"alimento para perro",2,200,"Alimentos",20);
		producto2.setPrecioTotal(producto2.calcularDescuento());
		Producto producto3 = new Producto(3,"collar",3,300,"Accesorios",40);
		producto3.setPrecioTotal(producto3.calcularDescuento());
		
		productos=new ArrayList<Producto>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
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