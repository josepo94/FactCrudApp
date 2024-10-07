package com.facturacion.app.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.dto.Impuesto;
import com.facturacion.app.entity.ImpuestoEntity;
import com.facturacion.app.entity.VentaEntity;
import com.facturacion.app.utils.Utils;
import com.facturacion.repository.ImpuestoRepository;
import com.facturacion.repository.VentaRepository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;



@Service			
public class ImpuestoService {
	private Utils utils = new Utils();

	private final ImpuestoRepository impuestoService;

	    public ImpuestoService(ImpuestoRepository impuestoRepository) {
	        this.impuestoService = impuestoRepository;
	    }

	    public GenericaResponse getAll() {
	    	try {
	    		List<ImpuestoEntity> impuesto = impuestoService.findAll();
		        if( impuesto.size()==0) {
		        	return utils.NotRegistersResponse();
		        }else {
		        	 ArrayList<Impuesto>  impuestoDtoArray = new ArrayList<Impuesto>();
		        	for (int i = 0 ; i < impuesto.size(); i++) {
		        		Impuesto impuestoDto = new Impuesto();
		        		impuestoDto.setId(impuesto.get(i).getId());
		        		impuestoDto.setNombre(impuesto.get(i).getNombre());
		        		impuestoDto.setPorcentaje(impuesto.get(i).getPorcentaje());
		        		impuestoDtoArray.add(impuestoDto);
		        	}
		        	return utils.OkResponse(impuestoDtoArray);
		        }
	    	}
	    	catch (Exception e) {
				return utils.ErrorNoControlado();
			}	
	    }



}
