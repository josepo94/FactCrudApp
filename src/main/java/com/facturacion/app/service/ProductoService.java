package com.facturacion.app.service;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.dto.Producto;
import com.facturacion.app.entity.ProductoEntity;

import com.facturacion.app.utils.Utils;
import com.facturacion.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service			
public class ProductoService {
	private Utils utils = new Utils();

	   private final ProductoRepository productoRepository;

	    public ProductoService(ProductoRepository productoRepository) {
	        this.productoRepository = productoRepository;
	    }

	    public GenericaResponse getAll() {
	    	try {
	    		List<ProductoEntity> productos = productoRepository.findAll();
		        if(productos.size()==0) {
		        	return utils.NotRegistersResponse();
		        }else {
		        	return utils.OkResponse(productos);
		        }
	    	}
	    	catch (Exception e) {
				return utils.ErrorNoControlado();
			}	
	    }

	    public GenericaResponse getByProveedorId(Long id) {
	    	try {
	    		if (productoRepository.findByProveedorId(id) != null){
	    			Producto productoDTO = new Producto();
	    			List<Producto> productoDTOList = new ArrayList<>();
	    			List<ProductoEntity> productoEntity = productoRepository.findByProveedorId(id);
	    			for(int i = 0; i < productoEntity.size(); i++) {
	    				productoDTO.setId(productoEntity.get(i).getId());
		    			productoDTO.setIdImpuesto(productoEntity.get(i).getImpuesto().getId());
		    			productoDTO.setIdProveedor(productoEntity.get(i).getProveedor().getId());
		    			productoDTO.setNombre(productoEntity.get(i).getNombre());
		    			productoDTO.setDescripcion(productoEntity.get(i).getDescripcion());
		    			productoDTO.setPrecio(productoEntity.get(i).getPrecio());
		    			productoDTOList.add(productoDTO);
	    			}
	    	
	    			return utils.OkResponse(productoDTOList);
	    		}else {
	    			return utils.NotRegistersResponse();
	    		}
	    	}catch(Exception E) {
	    			return utils.ErrorNoControlado();
	    	}    
	    }
	    
	    
	    public GenericaResponse getById(Long id) {
	    	try {
	    		if (productoRepository.findById(id) != null){
	    			Producto productoDTO = new Producto();
	    			List<Producto> productoDTOList = new ArrayList<>();
	    			Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
	    			
	  
	    				productoDTO.setId(productoEntity.get().getId());
		    			productoDTO.setIdImpuesto(productoEntity.get().getImpuesto().getId());
		    			productoDTO.setIdProveedor(productoEntity.get().getProveedor().getId());
		    			productoDTO.setIdProveedor(productoEntity.get().getProveedor().getId());
		    			productoDTO.setNombre(productoEntity.get().getNombre());
		    			productoDTO.setNombre(productoEntity.get().getNombre());
		    			productoDTO.setDescripcion(productoEntity.get().getDescripcion());
		    			productoDTO.setPrecio(productoEntity.get().getPrecio());
		    			productoDTOList.add(productoDTO);
	    			
	    	
	    			return utils.OkResponse(productoDTOList);
	    		}else {
	    			return utils.NotRegistersResponse();
	    		}
	    	}catch(Exception E) {
	    			return utils.ErrorNoControlado();
	    	}    
	    }
	    
	    
	    

	    public GenericaResponse create(ProductoEntity producto) {
	    	try {
	
	    		this.productoRepository.save(producto);
	    		return utils.OkResponse(producto);
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

	    public GenericaResponse update(Long id, ProductoEntity productoDetails) {
	    	try {
	    		 ProductoEntity producto = productoRepository.findById(id).orElse(null);
	 	        if (producto != null) {
	 	        	producto.setDescripcion(productoDetails.getDescripcion());
	 	        	producto.setImpuesto(productoDetails.getImpuesto());
	 	        	producto.setNombre(productoDetails.getNombre());
	 	        	producto.setPrecio(productoDetails.getPrecio());
	 	        	producto.setProveedor(productoDetails.getProveedor());
	 	        	producto.setImpuesto(productoDetails.getImpuesto());
	 	             return utils.OkResponse(producto);
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
	        productoRepository.deleteById(id);
	    }
	

}
