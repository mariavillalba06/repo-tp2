package ar.edu.unju.fi.listas;

import ar.edu.unju.fi.model.Producto;
import java.util.List;
import java.util.ArrayList;

public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto() {
		Producto producto1 = new Producto("arena para gatos",1,189,"Productos",0);
		producto1.setPrecioTotal(producto1.calcularDescuento());
		Producto producto2 = new Producto("alimento para perro",2,200,"Alimentos",20);
		producto2.setPrecioTotal(producto2.calcularDescuento());
		Producto producto3 = new Producto("collar",3,300,"Accesorios",40);
		producto3.setPrecioTotal(producto3.calcularDescuento());
		
		productos=new ArrayList<Producto>();
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}