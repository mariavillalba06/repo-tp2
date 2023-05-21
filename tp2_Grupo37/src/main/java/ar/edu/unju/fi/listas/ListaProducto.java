package ar.edu.unju.fi.listas;

import ar.edu.unju.fi.model.Producto;
import java.util.List;
import java.util.ArrayList;

public class ListaProducto {
	private List<Producto> productos;
	
	public ListaProducto() {
		productos=new ArrayList<Producto>();
		productos.add(new Producto("arena para gatos","abc1234",189,"Alimentos",0));
		productos.add(new Producto("arena para gatos","abc1234",189,"Alimentos",0));
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
