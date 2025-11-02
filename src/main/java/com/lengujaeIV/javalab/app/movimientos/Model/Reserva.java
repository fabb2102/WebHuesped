package com.lengujaeIV.javalab.app.movimientos.Model;

import java.sql.Date;

import com.lengujaeIV.javalab.app.maestro.Entity.Huesped;

public class Reserva {
	
	private Integer id_reserva;
    private Huesped id_huesped_responsable;
    private Integer id_usuario;
    private Date fecha_reserva;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String situacion;
    private float subtotal;
    private float descuento;
    private float total;
    private Integer cantidad_adultos;
    private Integer cantidad_ninos;
    private Integer cantidad_noches;
	public Reserva(Integer id_reserva, Huesped id_huesped_responsable, Integer id_usuario, Date fecha_reserva,
			Date fecha_inicio, Date fecha_fin, String situacion, float subtotal, float descuento, float total,
			Integer cantidad_adultos, Integer cantidad_ninos, Integer cantidad_noches) {
		super();
		this.id_reserva = id_reserva;
		this.id_huesped_responsable = id_huesped_responsable;
		this.id_usuario = id_usuario;
		this.fecha_reserva = fecha_reserva;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.situacion = situacion;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.total = total;
		this.cantidad_adultos = cantidad_adultos;
		this.cantidad_ninos = cantidad_ninos;
		this.cantidad_noches = cantidad_noches;
	}
	public Reserva() {
		super();
	}
	public Integer getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Huesped getId_huesped_responsable() {
		return id_huesped_responsable;
	}
	public void setId_huesped_responsable(Huesped id_huesped_responsable) {
		this.id_huesped_responsable = id_huesped_responsable;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getSituacion() {
		return situacion;
	}
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Integer getCantidad_adultos() {
		return cantidad_adultos;
	}
	public void setCantidad_adultos(Integer cantidad_adultos) {
		this.cantidad_adultos = cantidad_adultos;
	}
	public Integer getCantidad_ninos() {
		return cantidad_ninos;
	}
	public void setCantidad_ninos(Integer cantidad_ninos) {
		this.cantidad_ninos = cantidad_ninos;
	}
	public Integer getCantidad_noches() {
		return cantidad_noches;
	}
	public void setCantidad_noches(Integer cantidad_noches) {
		this.cantidad_noches = cantidad_noches;
	}

}
