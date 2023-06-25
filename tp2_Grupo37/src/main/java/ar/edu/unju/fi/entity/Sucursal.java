package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Component
@Entity
@Table(name="sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sucu_id")
	private Long id;
	
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	@Column(name = "sucu_nombre")
	private String nombre;
	
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	@Size(min=5, max=100,message="¡La direccion debe contener entre 5 y 100 caracteres!")
	@Column(name = "sucu_direccion")
	private String direccion;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="¡La fecha no puede ser null!")
	@Past(message="¡La fecha debe ser menor que la fecha actual!")
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="¡La fecha no puede ser null!")
	@Future(message="¡La fecha debe ser posterior a la fecha actual!")
	@Column(name = "fecha_fin")
	private LocalDate fechaFin;
	
	@NotEmpty(message="¡Este campo no puede quedar vacio!")
	@Email(message="¡Debe ingresar un email con formato valido!")
	@Column(name = "sucu_email")
	private String email;
	
	@NotEmpty(message="¡El campo telefono no puede ser vacio!")
	@Column(name = "sucu_telefono")
	private String telefono;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prov_id")
	@NotNull(message="Debe seleccionar una provincia")
	private Provincia provincia;
	
	@Column(name = "estado")
	private boolean estado;
	
	public Sucursal() {
	}

	
	
	public Sucursal(String nombre, String direccion, LocalDate fechaInicio, LocalDate fechaFin,String email,
			String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public boolean isEstado() {
		return estado;
	}

	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}	
	
	
}
