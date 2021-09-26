/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.services;

import co.edu.javeriana.ms.teentitans.Billing.models.Cart;
import co.edu.javeriana.ms.teentitans.Billing.models.Item;
import co.edu.javeriana.ms.teentitans.Billing.models.Order;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public interface IOrderService {

    public boolean createOrder(String id, String currency, String creditCard, List<Item> items);
    
    public List<Order> getOrders(String id);
    
    public Order getOrderById (String id, String idOrder);
    
    public void deleteOrderById (String id, String idOrder);
}
