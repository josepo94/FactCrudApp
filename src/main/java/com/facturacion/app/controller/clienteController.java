package com.facturacion.app.controller;
import org.springframework.web.bind.annotation.*;
import com.facturacion.app.dto.GenericaResponse;
import com.facturacion.app.entity.ClienteEntity;
import com.facturacion.app.entity.ProveedorEntity;
import com.facturacion.app.service.ClienteService;
import com.facturacion.app.service.ProveedorService;


@RestController
@RequestMapping("/clientes")

public class clienteController {
	
	private final ClienteService clienteService;

    public clienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    

    @GetMapping
    public GenericaResponse getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public GenericaResponse getClienteById(@PathVariable Long id) {
        return  clienteService.getClienteById(id);
    }

    @PostMapping
    public GenericaResponse createCliente(@RequestBody ClienteEntity cliente) {
        return clienteService.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public GenericaResponse updateCliente(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
       return clienteService.updateCliente(id, cliente);
    
    }
	

}
