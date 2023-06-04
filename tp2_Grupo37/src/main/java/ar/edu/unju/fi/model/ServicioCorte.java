package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Component
public class ServicioCorte {
	private int id;
	@DecimalMin(value = "1", inclusive = true, message = "El valor minimo es 1")
	@DecimalMax(value = "34", inclusive = true, message = "El valor máximo es 34")
	private byte pesoMinimo;
	@DecimalMin(value = "1", inclusive = true, message = "El valor minimo es 1")
	@DecimalMax(value = "34", inclusive = true, message = "El valor máximo es 34")
	private byte pesoMaximo;
	@NotBlank(message="Se debe seleccionar un instrumento")
	private String instrumento;
	@DecimalMin(value = "500", inclusive = true, message = "El valor minimo es 500")
	private int precio;
	
	public ServicioCorte() {
		// TODO Auto-generated constructor stub
	}

	public ServicioCorte(int id, byte pesoMinimo, byte pesoMaximo, String instrumento, int precio) {
		super();
		this.id = id;
		this.pesoMinimo = pesoMinimo;
		this.pesoMaximo = pesoMaximo;
		this.instrumento = instrumento;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
}
