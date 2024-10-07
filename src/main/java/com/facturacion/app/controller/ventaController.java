package com.facturacion.app.controller;
import org.springframework.web.bind.annotation.*;
import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.VentaEntity;
import com.facturacion.app.service.VentaService;


@RestController
@RequestMapping("/ventas")

public class ventaController {
	
	private final VentaService ventasService;

    public ventaController(VentaService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public GenericaResponse getAllProveedores() {
        return ventasService.getAll();
    }

    @GetMapping("/{id}")
    public GenericaResponse getById(@PathVariable Long id) {
        return  ventasService.getById(id);
    }

    @PostMapping
    public GenericaResponse create(@RequestBody VentaEntity venta) {
        return ventasService.create(venta);
    }

    @PutMapping("/{id}")
    public GenericaResponse updateProveedor(@PathVariable Long id, @RequestBody VentaEntity venta) {
       return ventasService.update(id, venta);
    
    }
	

}
