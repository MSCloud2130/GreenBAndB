/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.services;

import co.edu.javeriana.ms.teentitans.users.exceptions.UsernameAlreadyUsedException;
import co.edu.javeriana.ms.teentitans.users.model.Client;
import co.edu.javeriana.ms.teentitans.users.repository.ClientRepository;
import exceptions.ClientNotFoundException;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public class ClientService implements ClientServiceInterface{
    
    private final ClientRepository repository;
    
    private final PasswordEncoder  bCryptPasswordEncoder;

    public ClientService(ClientRepository repository, PasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @Override
    public Client createClient(Client client) {
        if (!repository.existsByUsernameAndEmail(client.getUsername(), client.getEmail())){
            client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
            return repository.save(client);
        }else {
            throw new UsernameAlreadyUsedException(client.getUsername());
        }
        
    }

    @Override
    public Client updateClient(Client client) {
        return repository.save(client);
    }

    @Override
    public void deleteClient(String id) {
        repository.deleteById(id);
    }

    @Override
    public Client getClientById(String id) {
        return repository.findById(id)
                .orElseThrow(()-> new ClientNotFoundException(id));
    }
    
   

    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }

    @Override
    public Client getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(()-> new ClientNotFoundException(username));
    }

    
    
    
}
