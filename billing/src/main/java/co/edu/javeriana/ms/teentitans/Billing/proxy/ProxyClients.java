/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.proxy;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author estudiantes
 */
@Component
public class ProxyClients {
    @Autowired
    WebClient usersWebClient;

    @Autowired
    WebClient servicesWebClient;
    
    public boolean clientExists(String  id) {
       try{
           usersWebClient
                .get()
                .uri(id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
           return true;
       }catch(RuntimeException e)
       {
           return false;
       }
       
    }
    public boolean serviceExists(String  id) {
       try{
           servicesWebClient
                .get()
                .uri(id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
           return true;
       }catch(RuntimeException e)
       {
           return false;
       }
       
    }

    public double getPrice(String id_service) {
        try{
           HashMap result = servicesWebClient
                .get()
                .uri(id_service)
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
           
           return 10000;
       }catch(RuntimeException e)
       {
           return 0;
       }
    }

    
}
