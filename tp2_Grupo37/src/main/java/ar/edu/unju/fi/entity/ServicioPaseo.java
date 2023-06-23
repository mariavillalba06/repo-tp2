package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
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
import jakarta.validation.constraints.NotNull;


@Component
@Entity
@Table(name="servicio_paseos")
public class ServicioPaseo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message="Se debe seleccionar un día")
	@Column(name = "dia")
	private String dia;
	
	@DecimalMin(value = "8", inclusive = true, message = "El valor minimo es 8")
	@DecimalMax(value = "20", inclusive = true, message = "El valor máximo es 20")
	@Column(name = "horario_inicio")
	private byte horarioInicio;
	
	@DecimalMax(value = "20", inclusive = true, message = "El valor máximo es 20")
	@Column(name = "horario_final")
	private byte horarioFinal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="emp_id")
	@NotNull(message="Debe seleccionar un empleado")
	private Empleado empleado;
	
	@Column(name = "estado")
	private boolean estado;
	
	public ServicioPaseo() {
		// TODO Auto-generated constructor stub
	}

	public ServicioPaseo(String dia, byte horarioInicio, byte horarioFinal) {
		super();
		this.dia = dia;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
