package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class ServicioPaseo {
	private int id;
	@NotEmpty(message="No puede tener el nombre vacio")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "Solo se permiten caracteres")
	@Pattern(regexp = "^[A-Z].*", message = "El nombre debe comenzar con una letra mayúscula")
	@Size(min = 3, message = "El nombre debe tener al menos tres caracteres")
	private String nombre;
	@NotBlank(message="Se debe seleccionar un día")
	private String dia;
	@DecimalMin(value = "8", inclusive = true, message = "El valor minimo es 8")
	@DecimalMax(value = "20", inclusive = true, message = "El valor máximo es 20")
	private byte horarioInicio;
	@DecimalMax(value = "20", inclusive = true, message = "El valor máximo es 20")
	private byte horarioFinal;
	
	public ServicioPaseo() {
		// TODO Auto-generated constructor stub
	}

	public ServicioPaseo(int id, String nombre, String dia, byte horarioInicio, byte horarioFinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dia = dia;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public byte getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(byte horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public byte getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(byte horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	
	
}
