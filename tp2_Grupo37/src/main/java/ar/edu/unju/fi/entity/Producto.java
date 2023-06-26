package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
@Entity
@Table(name="producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long id;
	
	private int numeroImg;
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	private String nombre;
	
	@NotNull(message="¡Este campo no puede quedar vacio!")
	@Positive(message="El precio debe tener valor un valor positivo")
	@Min(value=100,message="El precio no puede ser menor que 100")
	private float precio;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull(message="Debe seleccionar una categoria")
	@JoinColumn(name = "categ_id")
	private Categoria categoria;
	
	@Column(name = "estado")
	private boolean estado;
	
	private int descuento;
	private float precioTotal;
	 	 
	public Producto() {
	}	
	public Producto(int numeroImg, String nombre, float precio, int descuento) {
		super();
		this.numeroImg = numeroImg;
		this.nombre = nombre;
		this.precio = precio;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	

}