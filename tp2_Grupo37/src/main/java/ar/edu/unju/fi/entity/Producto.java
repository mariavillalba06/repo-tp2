package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
public class Producto {
	private int numeroImg;
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	 private String nombre;
	
	
	 private int codigo;
	
	@NotNull(message="¡Este campo no puede quedar vacio!")
	@Positive(message="El precio debe tener valor un valor positivo")
	@Min(value=100,message="El precio no puede ser menor que 100")
	 private float precio;
	
	@NotEmpty(message="¡Debe seleccionar una categoria!")
	 private String categoria;
	
	 private int descuento;
	 private float precioTotal;
	 	 
	public Producto() {
	}	
	public Producto(int numeroImg, String nombre, int codigo, float precio, String categoria, int descuento) {
		super();
		this.numeroImg = numeroImg;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}

	public int getNumeroImg() {
		return numeroImg;
	}
	public void setNumeroImg(int numeroImg) {
		this.numeroImg = numeroImg;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
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
	
	public float calcularDescuento() {
 		float precioFinal;
 		precioFinal=this.precio-(this.precio*this.descuento)/100;
 		
 		return precioFinal;
 	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
 
}