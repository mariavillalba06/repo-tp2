package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Component
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Long id;	
	@Column(name="prod_numImg")
	private int numeroImg;	
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	@Column(name="prod_nombre")
	private String nombre;	
	@Column(name="prod_codigo")
	private int codigo;	
	@NotNull(message="¡Este campo no puede quedar vacio!")
	@Positive(message="El precio debe tener valor un valor positivo")
	@Min(value=100,message="El precio no puede ser menor que 100")
	@Column(name="prod_precio")
	private float precio;	
	@ManyToOne
	private Categoria categoria;	
	@Column(name="prod_descuento")
	private int descuento;	
	@Column(name="prod_dprecioTotal")
	private float precioTotal;	
	private boolean estado;
	public Producto() {
	}	
	public Producto(Long id,int numeroImg, String nombre, int codigo, float precio, Categoria categoria, int descuento,boolean estado) {
		super();
		this.id=id;
		this.numeroImg = numeroImg;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
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

	public Categoria getCategoria() {
		return categoria;
		}
	public void setCategoria(Categoria categoria) {
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
	public boolean isEstado() {
		return estado;
	}
    public void setEstado(boolean estado) {
    	this.estado = estado;
    }

}