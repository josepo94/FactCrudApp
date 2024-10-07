package com.facturacion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.facturacion.app.entity.VentaProductoEntity;

public interface VentaProductoRepository extends JpaRepository<VentaProductoEntity, Long>{

}
