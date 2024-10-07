package com.facturacion.app.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "cliente")
public class ClienteEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, length = 100)
	    private String tipodocumento;

	    @Column(nullable = false, length = 100, unique = true)
	    private String numerodocumento;

	    @Column(nullable = false, length = 300)
	    private String nombrescompletos;

	    @Column(length = 10)
	    private String telefono;

	    @Column(length = 300)
	    private String direccion;

	    @OneToMany(mappedBy = "cliente")
	    private List<VentaEntity> ventas;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipodocumento() {
			return tipodocumento;
		}

		public void setTipodocumento(String tipodocumento) {
			this.tipodocumento = tipodocumento;
		}

		public String getNumerodocumento() {
			return numerodocumento;
		}

		public void setNumerodocumento(String numerodocumento) {
			this.numerodocumento = numerodocumento;
		}

		public String getNombrescompletos() {
			return nombrescompletos;
		}

		public void setNombrescompletos(String nombrescompletos) {
			this.nombrescompletos = nombrescompletos;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public List<VentaEntity> getVentas() {
			return ventas;
		}

		public void setVentas(List<VentaEntity> ventas) {
			this.ventas = ventas;
		}
	    
	    
}
