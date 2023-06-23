package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class Contacto {
	@NotEmpty(message="El nombre no puede estar vacío")
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "Solo se permiten caracteres")
	@Pattern(regexp = "^[A-Z].*", message = "El nombre debe comenzar con una letra mayúscula")
	private String nombre;
	@NotEmpty(message="El email no puede estar vacío")
	@Pattern(regexp="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message="Ingrese un correo electrónico válido. Ej:ejemplo123@gmail.com")
	private String email;
	@Size(min=10,max=50,message="La direccion debe ser entre 10 y 50 caracteres")
	private String ciudad;
	@NotEmpty(message="El mensaje no puede estar vacío")
	private String mensaje;
	
	/*
	 * Constructor
	 */
	public Contacto() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor parametrizado
	 * @param nombre
	 * @param email
	 * @param ciudad
	 * @param mensaje
	 */
	public Contacto(String nombre, String email, String ciudad, String mensaje) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.ciudad = ciudad;
		this.mensaje = mensaje;
	}

	/* GETTERS & SETTERS*/
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