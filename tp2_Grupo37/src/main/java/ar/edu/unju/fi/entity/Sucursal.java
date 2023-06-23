package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Component
public class Sucursal {
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	private String nombre;
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	@Size(min=5, max=100,message="¡La direccion debe contener entre 5 y 100 caracteres!")
	private String direccion;
	@NotEmpty(message="¡Debe seleccionar una provincia!")
	private String provincia;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="¡La fecha no puede ser null!")
	@Past(message="¡La fecha debe ser menor que la fecha actual!")
	private LocalDate fechaInicio;
	
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	@Email(message="¡Debe ingresar un email con formato valido!")
	private String email;
	
	@NotEmpty(message="¡El campo telefono no puede ser vacio!")
	private String telefono;
	
	public Sucursal() {
	}

	
	
	public Sucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	
}
