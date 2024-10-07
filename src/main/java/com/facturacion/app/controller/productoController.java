package com.facturacion.app.controller;
import org.springframework.web.bind.annotation.*;
import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.ProductoEntity;
import com.facturacion.app.entity.ProveedorEntity;
import com.facturacion.app.service.ProductoService;
import com.facturacion.app.service.ProveedorService;


@RestController
@RequestMapping("/producto")

public class productoController {
	
	private final ProductoService productoService;

    public productoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public GenericaResponse getAllProductos() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public GenericaResponse getProductosById(@PathVariable Long id) {
        return  productoService.getById(id);
    }

    @GetMapping("/proveedorId/{id}")
    public GenericaResponse getProductosByProveedorId(@PathVariable Long id) {
        return  productoService.getByProveedorId(id);
    }
    
    
    @PostMapping
    public GenericaResponse createProducto(@RequestBody ProductoEntity producto) {
        return productoService.create(producto);
    }

    @PutMapping("/{id}")
    public GenericaResponse updateProveedor(@PathVariable Long id, @RequestBody ProductoEntity producto) {
       return productoService.update(id, producto);
    
    }
	

}
