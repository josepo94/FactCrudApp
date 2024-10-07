package com.facturacion.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "venta_producto")
public class VentaProductoEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "venta_id", nullable = false)
	    private VentaEntity venta;

	    @ManyToOne
	    @JoinColumn(name = "producto_id", nullable = false)
	    private ProductoEntity producto;

	    @Column(nullable = false)
	    private Integer cantidad;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public VentaEntity getVenta() {
			return venta;
		}

		public void setVenta(VentaEntity venta) {
			this.venta = venta;
		}

		public ProductoEntity getProducto() {
			return producto;
		}

		public void setProducto(ProductoEntity producto) {
			this.producto = producto;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
	    
	    
}
