/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.users.services;

import co.edu.javeriana.ms.users.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public interface ClientServiceInterface {
    List<Client> getAllClients();
    Client createClient(Client supplier);
    Client updateClient(Client supplier);    
    void deleteClient(String id);
    Client getClientById(String id);
    Client getByUsername(String username);  

}
