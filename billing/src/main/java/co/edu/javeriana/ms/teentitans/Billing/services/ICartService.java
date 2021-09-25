/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.services;

import co.edu.javeriana.ms.teentitans.Billing.models.Cart;
import co.edu.javeriana.ms.teentitans.Billing.models.Item;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public interface ICartService {

    public Cart getCartById(String id);

    public Cart addCartItem(String id, Item newItem);

    public Cart setCartItemQuantity(String id, String idService, int quantity);

    public void deleteCartById(String id);

    public void deleteCartItem(String id, String idService);

    public void payCart(String id, String currency, String creditCard);
    
}
