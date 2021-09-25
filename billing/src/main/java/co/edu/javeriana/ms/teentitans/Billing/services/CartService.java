/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.services;

import co.edu.javeriana.ms.teentitans.Billing.models.Cart;
import co.edu.javeriana.ms.teentitans.Billing.models.Item;
import co.edu.javeriana.ms.teentitans.Billing.repositories.CartRepository;
import exceptions.CartNotFoundException;
import exceptions.UnableToCompletePurchaseException;
import java.util.ArrayList;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author estudiantes
 */
@Service
public class CartService implements ICartService {
    @Autowired
    CartRepository cartRepo;
    @Autowired
    IOrderService orderService;

    @Override
    public Cart getCartById(String id) {
        return cartRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
    }

    @Override
    public Cart addCartItem(String id, Item newItem) {
        Cart cart = cartRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        Boolean hasItem = false;
        int i = 0;
        while(i < cart.getItems().size() && !hasItem) {
            if (cart.getItems().get(i).getId_service().equals(newItem.getId_service())){
                hasItem = true;
                cart.getItems().get(i).setQuantity(
                    cart.getItems().get(i).getQuantity() + 1
                );
            }
            i++;
        }
        if (!hasItem)
            cart.getItems().add(newItem);
        return cartRepo.save(cart);
    }

    @Override
    public Cart setCartItemQuantity(String id, String idService, int quantity) {
        Cart cart = cartRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        int i = 0;
        Boolean found = false;
        while(i < cart.getItems().size() && !found){
            if (cart.getItems().get(i).getId_service().equals(idService)){
                found = true;
                cart.getItems().get(i).setQuantity(quantity);
            }
            i++;
        }
        return cartRepo.save(cart);
    }

    @Override
    public void deleteCartById(String id) {
        Cart cart = cartRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        cart.setItems(new ArrayList<>());
        cartRepo.save(cart);
        
    }

    @Override
    public void deleteCartItem(String id, String idService) {
        Cart cart = cartRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        int i = 0;
        Boolean found = false;
        while(i < cart.getItems().size() && !found){
            if (cart.getItems().get(i).getId_service().equals(idService)){
                found = true;
                cart.getItems().remove(i);
            }
            i++;
        }
        cartRepo.save(cart);
    }

    @Override
    public void payCart(String id, String currency, String creditCard) {
        Cart cart = cartRepo.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        if (orderService.createOrder(id,currency, creditCard, cart.getItems())){
            deleteCartById(id);
        }else {
            throw new UnableToCompletePurchaseException(id); 
        }
        
    }
    
}
