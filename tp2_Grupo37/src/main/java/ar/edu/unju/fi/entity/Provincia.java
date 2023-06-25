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
@Table(name="provincia")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prov_id")
	private Long id;
	
	@NotEmpty(message="No puede estar vacio")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "Solo se permiten caracteres")
	@Pattern(regexp = "^[A-Z].*", message = "El nombre debe comenzar con una letra mayúscula")
	@Size(min = 5, message = "El nombre debe tener al menos cinco caracteres")
	@Column(name = "prov_nombre")
	private String nombre;
	
	@Column(name = "estado")
	private boolean estado;
	
	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	public Provincia(String nombre) {
		this.nombre = nombre;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}