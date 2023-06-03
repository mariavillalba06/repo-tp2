package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Contacto {
	@NotEmpty(message="El nombre no puede estar vacío")
	private String nombre;
	@NotEmpty(message="El email no puede estar vacío")
	@Email(message="Debe ingresar un correo electronico válido")
	private String email;
	@Size(min=10,max=50,message="La direccion debe ser entre 10 y 50 caracteres")
	private String ciudad;
	@NotEmpty(message="El mensaje no puede estar vacío")
	private String mensaje;
	
	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public Contacto(String nombre, String email, String ciudad, String mensaje) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.ciudad = ciudad;
		this.mensaje = mensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}