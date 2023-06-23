package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Consejo {
	private int id;
	@NotEmpty(message="No puede estar vacío")
	private String titulo;
	@Size(min=10,message="El texto debe ser de 10 caracteres minimos")
	private String texto;
	@NotEmpty(message="La clave no puede estar vacía")
	@Size(max=200, message="La clave no puede tener mas de 200 caracteres")
	private String clave;
	
	/**
	 * Constructor
	 */
	public Consejo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor parametrizado
	 * @param id
	 * @param titulo
	 * @param texto
	 * @param clave
	 */
	public Consejo(int id, String titulo, String texto, String clave) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.clave = clave;
	}
	
	/* GETTERS & SETTERS*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
