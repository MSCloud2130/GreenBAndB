/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.users.services;

import co.edu.javeriana.ms.users.model.Supplier;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public interface SupplierServiceInterface {
    
    List<Supplier> getAllSuppliers();
    Supplier createSupplier(Supplier supplier);
    Supplier updateSupplier(Supplier supplier);    
    void deleteSupplier(String id);
    Supplier getSupplierById(String id);
    Supplier getByUsername(String username);   

}
