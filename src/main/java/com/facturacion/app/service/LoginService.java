package com.facturacion.app.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.dto.Producto;
import com.facturacion.app.dto.User;
import com.facturacion.app.entity.ProductoEntity;
import com.facturacion.app.entity.ProveedorEntity;
import com.facturacion.app.utils.Utils;
import com.facturacion.repository.ProductoRepository;
import com.facturacion.repository.ProveedorRepository;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;



@Service			
public class LoginService {


	   private final ProveedorRepository proveedorRepository;

	    public LoginService(ProveedorRepository proveedorRepository) {
	        this.proveedorRepository = proveedorRepository;
	    }
	    
	    public User devolverUsuario(String ruc) {
	    	User user = new User();
	    	try {
	    	    List<ProveedorEntity> proveedorEntity = proveedorRepository.findByRuc(ruc);
	    	    byte[] decodedBytes = Base64.getDecoder().decode(proveedorEntity.get(0).getClave());
	            String decodedString = new String(decodedBytes);
		        user.setPassword(decodedString);
		        user.setIdUser(proveedorEntity.get(0).getId());
		        user.setUsername(proveedorEntity.get(0).getRuc());
		        return(user);
	    	} catch (Exception e) {
	    		  
	    		return user;
			}
	    
	        // Crea y devuelve un objeto UserDetails basado en el usuario encontrado
	        
	       
	    }
}
