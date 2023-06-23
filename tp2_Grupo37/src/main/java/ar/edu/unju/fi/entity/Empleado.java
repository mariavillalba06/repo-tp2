package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@NotEmpty(message="No puede tener el nombre vacio")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "Solo se permiten caracteres")
	@Pattern(regexp = "^[A-Z].*", message = "El nombre debe comenzar con una letra mayúscula")
	@Size(min = 3, message = "El nombre debe tener al menos tres caracteres")
	@Column(name = "emp_nombre")
	private String nombre;
	
	@NotEmpty(message="No puede tener el apellido vacio")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "Solo se permiten caracteres")
	@Pattern(regexp = "^[A-Z].*", message = "El nombre debe comenzar con una letra mayúscula")
	@Size(min = 3, message = "El nombre debe tener al menos tres caracteres")
	@Column(name = "emp_apellido")
	private String apellido;
	
	@Column(name = "emp_estado")
	private boolean estado;

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
