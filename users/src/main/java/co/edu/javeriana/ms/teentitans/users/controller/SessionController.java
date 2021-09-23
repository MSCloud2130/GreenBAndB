/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.controller;

import co.edu.javeriana.ms.teentitans.users.model.Client;
import co.edu.javeriana.ms.teentitans.users.model.Request;
import co.edu.javeriana.ms.teentitans.users.model.Session;
import co.edu.javeriana.ms.teentitans.users.model.Supplier;
import co.edu.javeriana.ms.teentitans.users.services.SessionService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
