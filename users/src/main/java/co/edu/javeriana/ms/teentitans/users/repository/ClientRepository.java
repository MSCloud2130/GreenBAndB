/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.repository;

import co.edu.javeriana.ms.teentitans.users.model.Client;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author estudiantes
 */
public interface ClientRepository extends MongoRepository<Client, String>{
    Optional<Client> findByUsername ( String username );
    boolean existsByUsernameAndEmail( String username, String email);
}
