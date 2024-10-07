package com.facturacion.app.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.VentaEntity;
import com.facturacion.app.utils.Utils;
import com.facturacion.repository.VentaRepository;

import java.util.Base64;
import java.util.List;



@Service			
public class VentaService {
	private Utils utils = new Utils();

	private final VentaRepository ventaRepository;

	    public VentaService(VentaRepository ventasRepository) {
	        this.ventaRepository = ventasRepository;
	    }

	    public GenericaResponse getAll() {
	    	try {
	    		List<VentaEntity> ventas = ventaRepository.findAll();
		        if( ventas.size()==0) {
		        	return utils.NotRegistersResponse();
		        }else {
		        	return utils.OkResponse(ventas);
		        }
	    	}
	    	catch (Exception e) {
				return utils.ErrorNoControlado();
			}	
	    }

	    public GenericaResponse getById(Long id) {
	    	try {
	    		if (ventaRepository.findById(id) != null){
	    			return utils.OkResponse(ventaRepository.findById(id));
	    		}else {
	    			return utils.NotRegistersResponse();
	    		}
	    	}catch(Exception E) {
	    			return utils.ErrorNoControlado();
	    	}    
	    }
	    
	    

	    public GenericaResponse create(VentaEntity ventas) {
	    	try {
	    		this.ventaRepository.save(ventas);
	    		return utils.OkResponse(ventas);
	    	}
	    	 catch (DataIntegrityViolationException ex) {
	    			System.out.println(ex);
	 	    	  return utils.RepitedRegistersResponse();
	 	       }
	    	catch (Exception e) {
	    		System.out.println(e);
	    		return utils.ErrorNoControlado();
			}
	      
	    }

	    public GenericaResponse update(Long id, VentaEntity ventasDetails) {
	    	try {
	    		VentaEntity venta = ventaRepository.findById(id).orElse(null);
	 	        if (venta != null) {
	 	        	venta.setCliente(ventasDetails.getCliente());
	 	        	venta.setFecha(ventasDetails.getFecha());
	 	        	venta.setIva(ventasDetails.getIva());
	 	        	venta.setSubtotal(ventasDetails.getSubtotal());
	 	        	venta.setTotal(ventasDetails.getTotal());
	 	             return utils.OkResponse(venta);
	 	        }
	 	        else {
	 	        	return utils.NotRegistersResponse();
	 	        }
	    	}
	 	       catch (DataIntegrityViolationException ex) {
	 	    	  return utils.RepitedRegistersResponse();
	 	       }
	    	
	    		catch (Exception e) {
	    		 return utils.ErrorNoControlado();
			}
	       
	     
	    }

	    public void delete(Long id) {
	        ventaRepository.deleteById(id);
	    }
	

}
