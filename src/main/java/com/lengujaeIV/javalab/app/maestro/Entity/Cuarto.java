package com.lengujaeIV.javalab.app.maestro.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cuarto")
@Data
public class Cuarto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuarto;
	
	@Column(name="numero_cuarto")
	private Integer numeroCuarto;
	
	@Column(name="tipo_cuarto")
    private String tipoCuarto;
	
	@Column(name="precio_diario")
    private float precioDiario;
	
	@Column(name="cantidad_camas")
    private Integer cantidadCamas;
	
	@Column(name="capacidad_maxima")
    private Integer capacidadMaxima;
	
	@Column(name="estado")
    private String estado;
	
	@Column(name="descripcion")
    private String descripcion;
	
	@Column(name="vista")
    private String vista;
    
	public Cuarto(Integer idCuarto, Integer numeroCuarto, String tipoCuarto, float precioDiario,
			Integer cantidadCamas, Integer capacidadMaxima, String estado, String descripcion, String vista) {
		super();
		this.idCuarto = idCuarto;
		this.numeroCuarto = numeroCuarto;
		this.tipoCuarto = tipoCuarto;
		this.precioDiario = precioDiario;
		this.cantidadCamas = cantidadCamas;
		this.capacidadMaxima = capacidadMaxima;
		this.estado = estado;
		this.descripcion = descripcion;
		this.vista = vista;
	}
	
	public Cuarto() {
		super();
	}
	
	public Integer getIdCuarto() {
		return idCuarto;
	}
	
	public void setIdCuarto(Integer idCuarto) {
		this.idCuarto = idCuarto;
	}
	
	public Integer getNumeroCuarto() {
		return numeroCuarto;
	}
	
	public void setNumeroCuarto(Integer numeroCuarto) {
		this.numeroCuarto = numeroCuarto;
	}
	
	public String getTipoCuarto() {
		return tipoCuarto;
	}
	
	public void setTipoCuarto(String tipoCuarto) {
		this.tipoCuarto = tipoCuarto;
	}
	
	public float getPrecioDiario() {
		return precioDiario;
	}
	
	public void setPrecioDiario(float precioDiario) {
		this.precioDiario = precioDiario;
	}
	
	public Integer getCantidadCamas() {
		return cantidadCamas;
	}
	
	public void setCantidadCamas(Integer cantidadCamas) {
		this.cantidadCamas = cantidadCamas;
	}
	
	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getVista() {
		return vista;
	}
	
	public void setVista(String vista) {
		this.vista = vista;
	}
}
