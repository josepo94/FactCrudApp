package com.facturacion.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.app.entity.ImpuestoEntity;

public interface ImpuestoRepository extends JpaRepository<ImpuestoEntity, Long>{

}
