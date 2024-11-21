package com.emilio.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "este campo es nesesario")
	@Size(min = 3, max = 15)
	private String nombreUsuario;
	
	@NotBlank(message = "este campo es nesesario")
	@Size(min = 8)
	private String password;
	
	@Transient
	@NotBlank(message = "este campo es nesesario")
	private String confirmacionPassword;
	
	@NotBlank(message = "este campo es nesesario")
	@Email
	private String correo;
	
	@NotBlank(message = "este campo es nesesario")
	@Size(min = 3)
	@jakarta.validation.constraints.Pattern(regexp = "^[^\\d]*$", message = "El nombre no puede incluir números")
	private String nombre;
	
	@NotBlank(message = "este campo es nesesario")
	@Size(min = 3)
	@jakarta.validation.constraints.Pattern(regexp = "^[^\\d]*$", message = "El apellido no puede incluir números")
	private String apellido;
	
	@Past
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDeNacimiento;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmacionPassword() {
		return confirmacionPassword;
	}

	public void setConfirmacionPassword(String confirmacionPassword) {
		this.confirmacionPassword = confirmacionPassword;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
}
