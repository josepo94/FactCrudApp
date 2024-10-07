package com.facturacion.app.controller;
import org.springframework.web.bind.annotation.*;
import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.ProveedorEntity;
import com.facturacion.app.service.ProveedorService;


@RestController
@RequestMapping("/proveedores")

public class proveedorController {
	
	private final ProveedorService proveedorService;

    public proveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public GenericaResponse getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public GenericaResponse getProveedorById(@PathVariable Long id) {
        return  proveedorService.getProveedorById(id);
    }

    @PostMapping
    public GenericaResponse createProveedor(@RequestBody ProveedorEntity proveedor) {
        return proveedorService.createProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public GenericaResponse updateProveedor(@PathVariable Long id, @RequestBody ProveedorEntity proveedor) {
       return proveedorService.updateProveedor(id, proveedor);
    
    }
	

}
