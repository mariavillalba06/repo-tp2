package ar.edu.unju.fi.model;

public class Consejo {
	private int id;
	private String titulo;
	private String texto;
	private String clave;
	
	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	public Consejo(int id, String titulo, String texto, String clave) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.clave = clave;
	}

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
