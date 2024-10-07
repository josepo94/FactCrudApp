package com.facturacion.app.dto;

public class GenericaResponse {
private Integer estado;
private String mensaje;
private Object respuesta;

public Object getRespuesta() {
	return respuesta;
}
public void setRespuesta(Object respuesta) {
	this.respuesta = respuesta;
}
public Integer getEstado() {
	return estado;
}
public void setEstado(Integer estado) {
	this.estado = estado;
}
public String getMensaje() {
	return mensaje;
}
public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}

	


}
