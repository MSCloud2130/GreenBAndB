/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.controller;

import co.edu.javeriana.ms.teentitans.users.model.Client;
import co.edu.javeriana.ms.teentitans.users.services.ClientService;
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
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    
    ClientController(ClientService service) {
        this.service = service;
    }
    
    @GetMapping()
    List<Client> all() {
        return service.getAllClients();
    }
    
    @PostMapping()
    Client newClient(@RequestBody Client client){
        return service.createClient(client);
    }
    
    @PutMapping("/{id}")
    Client updateClient(@RequestBody Client client, @PathVariable String id) {
        return service.updateClient(client);
    }
    
    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable String id) {
        service.deleteClient(id);
    }
    
    @GetMapping("/{id}")
    Client getById(@PathVariable String id) {
        return service.getClientById(id);
    }
    
    @GetMapping("username/{username}")
    Client getByUsername(@PathVariable String username) {
        return service.getByUsername(username);
    }
    
}
