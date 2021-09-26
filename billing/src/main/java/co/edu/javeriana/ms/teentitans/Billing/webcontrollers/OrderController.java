/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.webcontrollers;

import co.edu.javeriana.ms.teentitans.Billing.models.Cart;
import co.edu.javeriana.ms.teentitans.Billing.models.Item;
import co.edu.javeriana.ms.teentitans.Billing.models.Order;
import co.edu.javeriana.ms.teentitans.Billing.services.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estudiantes
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrderService orderService;
    
  
    
    @GetMapping("/clients/{id}")
    List<Order> getOrders(@PathVariable("id") String id){
        //Cpnsumir servicio de cleintes.
        return orderService.getOrders(id);
    }
    
    @GetMapping("/clients/{id}/{idOrder}")
    Order getOrderById(@PathVariable("id") String id, @PathVariable("idOrder") String idOrder){
        //Cosumir sr clients
        return orderService.getOrderById(id, idOrder);
    }
    
    @DeleteMapping("/clients/{id}/{idOrder}")
    void deleteOrderById(@PathVariable("id") String id, @PathVariable("idOrder") String idOrder){
        //Cosumir sr clients
         orderService.deleteOrderById(id, idOrder);
    }
    
    
  
    
    
}
