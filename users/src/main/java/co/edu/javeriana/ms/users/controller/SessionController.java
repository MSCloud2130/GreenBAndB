/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.users.controller;

import co.edu.javeriana.ms.users.model.Session;
import co.edu.javeriana.ms.users.services.SessionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estudiantes
 */
@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService service;

    SessionController(SessionService service) {
        this.service = service;
    }

    @PostMapping()
    Session newSupplierr(@RequestParam String username, @RequestParam String password){
        return service.createSession(username, password);

    }

    @DeleteMapping("/{id}")
    void deleteSupplier(@PathVariable String id) {
        service.deleteSession(id);
    }

}
