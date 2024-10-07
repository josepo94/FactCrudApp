package com.facturacion.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.app.entity.ProveedorEntity;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>{

	   List<ProveedorEntity> findByRuc(String ruc);
}
