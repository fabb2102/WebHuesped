package com.lengujaeIV.javalab.app.movimientos.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lengujaeIV.javalab.app.maestro.Entity.Huesped;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="reserva")
@Data
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	
	@OneToOne(fetch = FetchType.EAGER)  
	@JoinColumn(name = "id_huesped_responsable")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Huesped idHuespedResponsable;
	
	@Column(name="id_usuario")
    private Integer idUsuario;
	
	@Column(name="fecha_reserva")
    private Date fechaReserva;
	
	@Column(name="fecha_inicio")
    private Date fechaInicio;
	
	@Column(name="fecha_fin")
    private Date fechaFin;
	
	@Column(name="situacion")
    private String situacion;
	
	@Column(name="subtotal")
    private float subtotal;
	
	@Column(name="descuento")
    private float descuento;
	
	@Column(name="total")
    private float total;
	
	@Column(name="cantidad_adultos")
    private Integer cantidadAdultos;
	
	@Column(name="cantidad_ninos")
    private Integer cantidadNinos;
	
	@Column(name="cantidad_noches")
    private Integer cantidadNoches;
	
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idHuespedResponsable=" + idHuespedResponsable
				+ ", idUsuario=" + idUsuario + ", fechaReserva=" + fechaReserva + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", situacion=" + situacion + ", subtotal=" + subtotal + ", descuento="
				+ descuento + ", total=" + total + ", cantidadAdultos=" + cantidadAdultos + ", cantidadNinos="
				+ cantidadNinos + ", cantidadNoches=" + cantidadNoches + "]";
	}
	
	public Reserva(Integer idReserva, Huesped idHuespedResponsable, Integer idUsuario, Date fechaReserva,
			Date fechaInicio, Date fechaFin, String situacion, float subtotal, float descuento, float total,
			Integer cantidadAdultos, Integer cantidadNinos, Integer cantidadNoches) {
		super();
		this.idReserva = idReserva;
		this.idHuespedResponsable = idHuespedResponsable;
		this.idUsuario = idUsuario;
		this.fechaReserva = fechaReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.situacion = situacion;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.total = total;
		this.cantidadAdultos = cantidadAdultos;
		this.cantidadNinos = cantidadNinos;
		this.cantidadNoches = cantidadNoches;
	}
	
	public Reserva() {
		super();
	}
	
	public Integer getIdReserva() {
		return idReserva;
	}
	
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	
	public Huesped getIdHuespedResponsable() {
		return idHuespedResponsable;
	}
	
	public void setIdHuespedResponsable(Huesped idHuespedResponsable) {
		this.idHuespedResponsable = idHuespedResponsable;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Date getFechaReserva() {
		return fechaReserva;
	}
	
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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
	
	public Integer getCantidadAdultos() {
		return cantidadAdultos;
	}
	
	public void setCantidadAdultos(Integer cantidadAdultos) {
		this.cantidadAdultos = cantidadAdultos;
	}
	
	public Integer getCantidadNinos() {
		return cantidadNinos;
	}
	
	public void setCantidadNinos(Integer cantidadNinos) {
		this.cantidadNinos = cantidadNinos;
	}
	
	public Integer getCantidadNoches() {
		return cantidadNoches;
	}
	
	public void setCantidadNoches(Integer cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}
}
