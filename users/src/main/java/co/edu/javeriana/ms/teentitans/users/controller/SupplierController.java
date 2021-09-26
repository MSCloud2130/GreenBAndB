/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.controller;

import co.edu.javeriana.ms.teentitans.users.model.Supplier;
import co.edu.javeriana.ms.teentitans.users.services.SupplierService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estudiantes
 */
@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    
    private final SupplierService service;
    
    SupplierController(SupplierService service) {
        this.service = service;
    }
    
    @GetMapping()
    List<Supplier> all() {
        return service.getAllSuppliers();
    }
    
    @PostMapping()
    Supplier newSupplier(@RequestBody Supplier supplier){
        return service.createSupplier(supplier);
    }
    
    @PutMapping("/{id}")
    Supplier updateSupplier(@RequestBody Supplier supplier, @PathVariable Long id) {
        return service.updateSupplier(supplier);
    }
    
    @DeleteMapping("/{id}")
    void deleteSupplier(@PathVariable String id) {
        service.deleteSupplier(id);
    }
    
    @GetMapping("/{id}")
    Supplier getById(@PathVariable String id) {
        return service.getSupplierById(id);
    }
    
    @GetMapping("/username/{username}")
    Supplier getByUsername(@PathVariable String username) {
        return service.getByUsername(username);
    }
    
}
