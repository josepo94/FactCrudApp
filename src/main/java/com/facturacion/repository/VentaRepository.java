package com.facturacion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.facturacion.app.entity.VentaEntity;

public interface VentaRepository extends JpaRepository<VentaEntity, Long>{

}
