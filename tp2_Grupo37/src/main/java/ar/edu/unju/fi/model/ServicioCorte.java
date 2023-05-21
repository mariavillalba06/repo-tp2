package ar.edu.unju.fi.model;

public class ServicioCorte {
	private int id;
	private byte pesoMinimo;
	private byte pesoMaximo;
	private String instrumento;
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
