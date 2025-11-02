package com.lengujaeIV.javalab.app.maestro.Model;

public class Cuarto {
	
	private Integer id_cuarto;
	private Integer numero_cuarto;
    private String tipo_cuarto;
    private float precio_diario;
    private Integer cantidad_camas;
    private Integer capacidad_maxima;
    private String estado;
    private String descripcion;
    private String vista;
    
	public Cuarto(Integer id_cuarto, Integer numero_cuarto, String tipo_cuarto, float precio_diario,
			Integer cantidad_camas, Integer capacidad_maxima, String estado, String descripcion, String vista) {
		super();
		this.id_cuarto = id_cuarto;
		this.numero_cuarto = numero_cuarto;
		this.tipo_cuarto = tipo_cuarto;
		this.precio_diario = precio_diario;
		this.cantidad_camas = cantidad_camas;
		this.capacidad_maxima = capacidad_maxima;
		this.estado = estado;
		this.descripcion = descripcion;
		this.vista = vista;
	}
	public Cuarto() {
		super();
	}
	public Integer getId_cuarto() {
		return id_cuarto;
	}
	public void setId_cuarto(Integer id_cuarto) {
		this.id_cuarto = id_cuarto;
	}
	public Integer getNumero_cuarto() {
		return numero_cuarto;
	}
	public void setNumero_cuarto(Integer numero_cuarto) {
		this.numero_cuarto = numero_cuarto;
	}
	public String getTipo_cuarto() {
		return tipo_cuarto;
	}
	public void setTipo_cuarto(String tipo_cuarto) {
		this.tipo_cuarto = tipo_cuarto;
	}
	public float getPrecio_diario() {
		return precio_diario;
	}
	public void setPrecio_diario(float precio_diario) {
		this.precio_diario = precio_diario;
	}
	public Integer getCantidad_camas() {
		return cantidad_camas;
	}
	public void setCantidad_camas(Integer cantidad_camas) {
		this.cantidad_camas = cantidad_camas;
	}
	public Integer getCapacidad_maxima() {
		return capacidad_maxima;
	}
	public void setCapacidad_maxima(Integer capacidad_maxima) {
		this.capacidad_maxima = capacidad_maxima;
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
