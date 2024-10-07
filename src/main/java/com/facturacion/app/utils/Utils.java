package com.facturacion.app.utils;

import com.facturacion.app.dto.GenericaResponse;

public class Utils {
	
	public  GenericaResponse ErrorNoControlado() {
		GenericaResponse response = new GenericaResponse();
		response.setEstado(500);
		response.setMensaje("Ha ocurrido un errror no controlado en la petición");
	return response;
	}

	public  GenericaResponse OkResponse(Object respuesta) {
		GenericaResponse response = new GenericaResponse();
		response.setEstado(200);
		response.setMensaje("Respuesta exitosa");
		response.setRespuesta(respuesta);
	return response;
	}
	
	public  GenericaResponse UnauthorizedResponse() {
		GenericaResponse response = new GenericaResponse();
		response.setEstado(401);
		response.setMensaje("Clave o usuario incorrectos");
	return response;
	}
	
	
	public  GenericaResponse NotRegistersResponse() {
		GenericaResponse response = new GenericaResponse();
		response.setEstado(200);
		response.setMensaje("No existen registros");
		response.setRespuesta(null);
	return response;
	}
	
	public  GenericaResponse RepitedRegistersResponse() {
		GenericaResponse response = new GenericaResponse();
		response.setEstado(500);
		response.setMensaje("Los registros que se desean guardar ya existen");
		response.setRespuesta(null);
	return response;
	}
	
}
