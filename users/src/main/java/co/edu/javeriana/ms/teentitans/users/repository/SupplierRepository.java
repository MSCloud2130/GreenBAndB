/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.repository;

import co.edu.javeriana.ms.teentitans.users.model.Supplier;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author estudiantes
 */
public interface SupplierRepository extends MongoRepository<Supplier, String>{
    
        Optional<Supplier> findByUsername ( String username );
        boolean existsByUsernameAndEmail( String username, String email);
}
