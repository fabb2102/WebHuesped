package com.lengujaeIV.javalab.app.maestro.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="huesped")
@Data
public class Huesped {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHuesped;
	
	@Column(name="nombre")
    private String nombre; 
	
	@Column(name="apellido")
    private String apellido;
	
	@Column(name="documento")
    private String documento;
	
	@Column(name="email")
    private String email;
	
	@Column(name="direccion")
    private String direccion; 
	
	@Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
	
	@Column(name="nacionalidad")
    private String nacionalidad;
	
	@Column(name="observacion")
    private String observacion;
    
	public Huesped(Integer idHuesped, String nombre, String apellido, String documento, String email, String direccion,
			Date fechaNacimiento, String nacionalidad, String observacion) {
		super();
		this.idHuesped = idHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.observacion = observacion;
	}

	public Huesped() {
		super();
	}

	public Integer getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(Integer idHuesped) {
		this.idHuesped = idHuesped;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}