package com.facturacion.app.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.dto.Proveedor;
import com.facturacion.app.entity.ProveedorEntity;
import com.facturacion.app.utils.Utils;
import com.facturacion.repository.ProveedorRepository;


import java.util.Base64;
import java.util.List;
import java.util.Optional;



@Service			
public class ProveedorService {
	private Utils utils = new Utils();

	   private final ProveedorRepository proveedorRepository;

	    public ProveedorService(ProveedorRepository proveedorRepository) {
	        this.proveedorRepository = proveedorRepository;
	    }
	    
	    
	    public String getByRuc(String ruc) {
	    	try {
	    		List<ProveedorEntity> proveedores = proveedorRepository.findByRuc(ruc);
	
		        	return proveedores.get(0).getClave();
		        
	    	}
	    	catch (Exception e) {
				return null;
			}	
	    }
	    

	    public GenericaResponse getAllProveedores() {
	    	try {
	    		List<ProveedorEntity> proveedores = proveedorRepository.findAll();
		        if(proveedores.size()==0) {
		        	return utils.NotRegistersResponse();
		        }else {
		        	return utils.OkResponse(proveedores);
		        }
	    	}
	    	catch (Exception e) {
				return utils.ErrorNoControlado();
			}	
	    }

	    public GenericaResponse getProveedorById(Long id) {
	    	try {
	    		if (proveedorRepository.findById(id) != null){
	    			Optional<ProveedorEntity> respuest = proveedorRepository.findById(id);
	    			Proveedor proveedor = new Proveedor();
	    			proveedor.setNombre(respuest.get().getNombre());
	    			proveedor.setClave(respuest.get().getClave());
	    			proveedor.setDireccion(respuest.get().getDireccion());
	    			proveedor.setEmail(respuest.get().getEmail());
	    			proveedor.setId(respuest.get().getId());
	    			proveedor.setRuc(respuest.get().getRuc());
	    			proveedor.setTelefono(respuest.get().getTelefono());
	    			return utils.OkResponse(proveedor);
	    		}else {
	    			return utils.NotRegistersResponse();
	    		}
	    	}catch(Exception E) {
	    			return utils.ErrorNoControlado();
	    	}    
	    }
	    
	    

	    public GenericaResponse createProveedor(ProveedorEntity proveedor) {
	    	try {
	        	 String encodedString = Base64.getEncoder().encodeToString(proveedor.getClave().getBytes());
	 	        	proveedor.setClave(encodedString);
	    		this.proveedorRepository.save(proveedor);
	    		return utils.OkResponse(proveedor);
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

	    public GenericaResponse updateProveedor(Long id, ProveedorEntity proveedorDetails) {
	    	try {
	    		 ProveedorEntity proveedor = proveedorRepository.findById(id).orElse(null);
	 	        if (proveedor != null) {
	 	        	 String encodedString = Base64.getEncoder().encodeToString(proveedorDetails.getClave().getBytes());
	 	        	proveedor.setClave(encodedString);
	 	        	proveedor.setRuc(proveedorDetails.getRuc());
	 	            proveedor.setNombre(proveedorDetails.getNombre());
	 	            proveedor.setDireccion(proveedorDetails.getDireccion());
	 	            proveedor.setTelefono(proveedorDetails.getTelefono());
	 	            proveedor.setEmail(proveedorDetails.getEmail());
	 	             proveedorRepository.save(proveedor);
	 	             return utils.OkResponse(proveedor);
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

	    public void deleteProveedor(Long id) {
	        proveedorRepository.deleteById(id);
	    }
	

}
