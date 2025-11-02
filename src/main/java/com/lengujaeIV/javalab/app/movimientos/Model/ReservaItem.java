package com.lengujaeIV.javalab.app.movimientos.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ReservaItem {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Integer id_item;
		@ManyToOne(fetch = FetchType.EAGER)  // ← Cargar siempre
		@JoinColumn(name = "id_reserva")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Integer id_reserva;
		@ManyToOne(fetch = FetchType.EAGER)  // ← Cargar siempre
		@JoinColumn(name = "id_cuarto")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Integer id_cuarto;
		@ManyToOne(fetch = FetchType.EAGER)  // ← Cargar siempre
		@JoinColumn(name = "id_huesped")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Integer id_huesped;
		@Column(name="precio_noche")
	    private float precio_noche;
		@Column(name="descuento")
	    private float descuento;
		@Column(name="subtotal")
	    private float subtotal;
		public ReservaItem(Integer id_item, Integer id_reserva, Integer id_cuarto, Integer id_huesped,
				float precio_noche, float descuento, float subtotal) {
			super();
			this.id_item = id_item;
			this.id_reserva = id_reserva;
			this.id_cuarto = id_cuarto;
			this.id_huesped = id_huesped;
			this.precio_noche = precio_noche;
			this.descuento = descuento;
			this.subtotal = subtotal;
		}
		public ReservaItem() {
			super();
		}
		public Integer getId_item() {
			return id_item;
		}
		public void setId_item(Integer id_item) {
			this.id_item = id_item;
		}
		public Integer getId_reserva() {
			return id_reserva;
		}
		public void setId_reserva(Integer id_reserva) {
			this.id_reserva = id_reserva;
		}
		public Integer getId_cuarto() {
			return id_cuarto;
		}
		public void setId_cuarto(Integer id_cuarto) {
			this.id_cuarto = id_cuarto;
		}
		public Integer getId_huesped() {
			return id_huesped;
		}
		public void setId_huesped(Integer id_huesped) {
			this.id_huesped = id_huesped;
		}
		public float getPrecio_noche() {
			return precio_noche;
		}
		public void setPrecio_noche(float precio_noche) {
			this.precio_noche = precio_noche;
		}
		public float getDescuento() {
			return descuento;
		}
		public void setDescuento(float descuento) {
			this.descuento = descuento;
		}
		public float getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(float subtotal) {
			this.subtotal = subtotal;
		}
	    
	    

}
