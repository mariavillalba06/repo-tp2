package ar.edu.unju.fi.model;

public class Producto {
	 private String nombrecod;
	 private String codigo;
	 private int precio;
	 private String categoria;
	 private int descuento;
	 	 
	public Producto() {
	}	
	public Producto(String nombrecod, String codigo, int precio, String categoria, int descuento) {
		super();
		this.nombrecod = nombrecod;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}



	
	public String getNombrecod() {
		return nombrecod;
	}
	public void setNombrecod(String nombrecod) {
		this.nombrecod = nombrecod;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	 
 
}
