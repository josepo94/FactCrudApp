package com.facturacion.app.controller;
import org.springframework.web.bind.annotation.*;
import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.VentaEntity;
import com.facturacion.app.service.ImpuestoService;
import com.facturacion.app.service.VentaService;


@RestController
@RequestMapping("/impuestos")

public class impuestoController {
	
	private final ImpuestoService impuestoService;

    public impuestoController(ImpuestoService impuestoService) {
        this.impuestoService = impuestoService;
    }

    @GetMapping
    public GenericaResponse getAll() {
        return impuestoService.getAll();
    }

 

}
