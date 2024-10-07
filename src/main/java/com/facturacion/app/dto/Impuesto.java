package com.facturacion.app.dto;

import java.math.BigDecimal;

public class Impuesto {
private Long id ;
private String nombre ;
private BigDecimal porcentaje ;

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


	


}
