package com.lengujaeIV.javalab.app.maestro.Model;

import java.sql.Date;

public class Huesped {
	
	private int id_huesped;
    private String nombre; 
    private String apellido; 
    private String documento;
    private String email;
    private String direccion; 
    private Date fecha_nacimiento;
    private String nacionalidad;
    private String observacion;
    
	public Huesped(int id_huesped, String nombre, String apellido, String documento, String email, String direccion,
			Date fecha_nacimiento, String nacionalidad, String observacion) {
		super();
		this.id_huesped = id_huesped;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.email = email;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.observacion = observacion;
	}

	public Huesped() {
		super();
	}

	public int getId_huesped() {
		return id_huesped;
	}

	public void setId_huesped(int id_huesped) {
		this.id_huesped = id_huesped;
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

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
