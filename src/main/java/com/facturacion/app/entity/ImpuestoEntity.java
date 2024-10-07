package com.facturacion.app.entity;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "impuesto")
public class ImpuestoEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 100)
	    private String nombre;

	    @Column(nullable = false, precision = 5, scale = 2)
	    private BigDecimal porcentaje;

	    @OneToMany(mappedBy = "impuesto")
	    private List<ProductoEntity> productos;

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

	

		public BigDecimal getPorcentaje() {
			return porcentaje;
		}

		public void setPorcentaje(BigDecimal porcentaje) {
			this.porcentaje = porcentaje;
		}

		public List<ProductoEntity> getProductos() {
			return productos;
		}

		public void setProductos(List<ProductoEntity> productos) {
			this.productos = productos;
		}

	    
}
