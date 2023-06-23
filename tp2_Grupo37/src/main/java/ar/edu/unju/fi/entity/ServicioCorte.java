package ar.edu.unju.fi.entity;

import jakarta.persistence.Column;

import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Component
@Entity
@Table(name="servicio_cortes")
public class ServicioCorte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message="Se debe seleccionar un día")
	@Column(name = "dia")
	private String dia;
	
	@DecimalMin(value = "1", inclusive = true, message = "El valor minimo es 1")
	@DecimalMax(value = "34", inclusive = true, message = "El valor máximo es 34")
	@Column(name = "peso_minimo", nullable = true)
	private byte pesoMinimo;
	
	@DecimalMin(value = "1", inclusive = true, message = "El valor minimo es 1")
	@DecimalMax(value = "34", inclusive = true, message = "El valor máximo es 34")
	@Column(name = "peso_maximo", nullable = true)
	private byte pesoMaximo;
	
	@NotBlank(message="Se debe seleccionar un instrumento")
	@Column(name = "instrumento", nullable = true)
	private String instrumento;
	
	@DecimalMin(value = "500", inclusive = true, message = "El valor minimo es 500")
	@Column(name = "precio", nullable = true)
	private int precio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="emp_id")
	@NotNull(message="Debe seleccionar un empleado")
	private Empleado empleado;
	
	@Column(name = "estado")
	private boolean estado;
	
	public ServicioCorte() {
		// TODO Auto-generated constructor stub
	}

	public ServicioCorte(String dia, byte pesoMinimo, byte pesoMaximo, String instrumento, int precio) {
		super();
		this.dia = dia;
		this.pesoMinimo = pesoMinimo;
		this.pesoMaximo = pesoMaximo;
		this.instrumento = instrumento;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(byte pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	public byte getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(byte pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
}
