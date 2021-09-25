/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.services;

import co.edu.javeriana.ms.teentitans.Billing.models.Item;
import co.edu.javeriana.ms.teentitans.Billing.models.Order;
import co.edu.javeriana.ms.teentitans.Billing.repositories.CartRepository;
import co.edu.javeriana.ms.teentitans.Billing.repositories.OrderRepository;
import exceptions.CartNotFoundException;
import exceptions.OrderNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public class OrderService implements IOrderService{
    @Autowired
    OrderRepository orderRepo;

    @Override
    public boolean createOrder(String idclient, String currency, String creditCard, List<Item> items) {
        if(creditCard.length() >= 16 )
        {
            Order order = new Order(idclient,currency,creditCard, items );
            orderRepo.save(order);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Order> getOrders(String id) {
        return null; //orderRepo.fin
    }

    @Override
    public Order getOrderById(String id) {
         return orderRepo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }



    
}
