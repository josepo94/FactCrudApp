package com.facturacion.app.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.ClienteEntity;
import com.facturacion.app.entity.ProveedorEntity;
import com.facturacion.app.utils.Utils;
import com.facturacion.repository.ClienteRepository;
import com.facturacion.repository.ProveedorRepository;

import java.util.Base64;
import java.util.List;



@Service			
public class ClienteService {
	private Utils utils = new Utils();

	   private final ClienteRepository clienteRepository;

	    public ClienteService(ClienteRepository clienteRepository) {
	        this.clienteRepository = clienteRepository;
	    }

	    public GenericaResponse getAllClientes() {
	    	try {
	    		List<ClienteEntity> clientes = clienteRepository.findAll();
		        if(clientes.size()==0) {
		        	return utils.NotRegistersResponse();
		        }else {
		        	return utils.OkResponse(clientes);
		        }
	    	}
	    	catch (Exception e) {
				return utils.ErrorNoControlado();
			}	
	    }

	    public GenericaResponse getClienteById(Long id) {
	    	try {
	    		if (clienteRepository.findById(id) != null){
	    			return utils.OkResponse(clienteRepository.findById(id));
	    		}else {
	    			return utils.NotRegistersResponse();
	    		}
	    	}catch(Exception E) {
	    			return utils.ErrorNoControlado();
	    	}    
	    }
	    
	    

	    public GenericaResponse createCliente(ClienteEntity cliente) {
	    	try {
	    		this.clienteRepository.save(cliente);
	    		return utils.OkResponse(cliente);
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

	    public GenericaResponse updateCliente(Long id, ClienteEntity clienteDetails) {
	    	try {
	    		 ClienteEntity cliente = clienteRepository.findById(id).orElse(null);
	 	        if (cliente != null) {
	 	        	cliente.setDireccion(clienteDetails.getDireccion());
	 	        	cliente.setNombrescompletos(clienteDetails.getNombrescompletos());
	 	        	cliente.setNumerodocumento(clienteDetails.getNumerodocumento());
	 	        	cliente.setTelefono(clienteDetails.getTelefono());
	 	        	cliente.setTipodocumento(clienteDetails.getTipodocumento());
	 	        	return utils.OkResponse(cliente);
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

	    public void deleteCliente(Long id) {
	        clienteRepository.deleteById(id);
	    }
	

}
