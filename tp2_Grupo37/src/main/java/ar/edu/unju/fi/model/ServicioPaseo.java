package ar.edu.unju.fi.model;

public class ServicioPaseo {
	private int id;
	private String nombre;
	private String dia;
	private byte horarioInicio;
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
