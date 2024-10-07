package com.facturacion.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.app.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
