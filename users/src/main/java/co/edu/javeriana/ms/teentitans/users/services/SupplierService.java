/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.services;

import co.edu.javeriana.ms.teentitans.users.exceptions.UsernameAlreadyUsedException;
import co.edu.javeriana.ms.teentitans.users.model.Supplier;
import co.edu.javeriana.ms.teentitans.users.repository.SupplierRepository;
import exceptions.ClientNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public class SupplierService implements SupplierServiceInterface {

    private final SupplierRepository repository;
    private final PasswordEncoder  bCryptPasswordEncoder;

    public SupplierService(SupplierRepository repository, PasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    
    
    @Override
    public Supplier createSupplier(Supplier supplier) {
        if (!repository.existsByUsernameAndEmail(supplier.getUsername(), supplier.getEmail())){
            supplier.setPassword(bCryptPasswordEncoder.encode(supplier.getPassword()));
            return repository.save(supplier);
        }else {
            throw new UsernameAlreadyUsedException(supplier.getUsername());
        }
        
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public void deleteSupplier(String id) {
        repository.deleteById(id);
    }

    @Override
    public Supplier getSupplierById(String id) {
        return repository.findById(id).orElseThrow(() -> 
        new ClientNotFoundException(id));
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public Supplier getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(
                        () -> new ClientNotFoundException(username));
    }
    
    
}
