package com.facturacion.app.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
public class ProductoEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 100)
	    private String nombre;

	    @Column(length = 100)
	    private String descripcion;

	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal precio;

	    @ManyToOne
	    @JoinColumn(name = "proveedor_id", nullable = false)
	    private ProveedorEntity proveedor;

	    @ManyToOne
	    @JoinColumn(name = "impuesto_id")
	    private ImpuestoEntity impuesto;

	    @OneToMany(mappedBy = "producto")
	    private List<VentaProductoEntity> ventasProducto;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

	
		public BigDecimal getPrecio() {
			return precio;
		}

		public void setPrecio(BigDecimal precio) {
			this.precio = precio;
		}

		public ProveedorEntity getProveedor() {
			return proveedor;
		}

		public void setProveedor(ProveedorEntity proveedor) {
			this.proveedor = proveedor;
		}

		public ImpuestoEntity getImpuesto() {
			return impuesto;
		}

		public void setImpuesto(ImpuestoEntity impuesto) {
			this.impuesto = impuesto;
		}

		public List<VentaProductoEntity> getVentasProducto() {
			return ventasProducto;
		}

		public void setVentasProducto(List<VentaProductoEntity> ventasProducto) {
			this.ventasProducto = ventasProducto;
		}
	    
	    
}
