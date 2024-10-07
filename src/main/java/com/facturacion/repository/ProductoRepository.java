package com.facturacion.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.app.entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
	   List<ProductoEntity> findByProveedorId(Long proveedorId);
	   
}
