package com.facturacion.app.dto;

import java.math.BigDecimal;

public class Producto {
private Long id;
private String nombre;
private String descripcion;
private BigDecimal precio;
private Long idProveedor;
private Long idImpuesto;
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
public BigDecimal getPrecio() {
	return precio;
}
public void setPrecio(BigDecimal precio) {
	this.precio = precio;
}
public Long getIdProveedor() {
	return idProveedor;
}
public void setIdProveedor(Long idProveedor) {
	this.idProveedor = idProveedor;
}
public Long getIdImpuesto() {
	return idImpuesto;
}
public void setIdImpuesto(Long idImpuesto) {
	this.idImpuesto = idImpuesto;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


	


}
