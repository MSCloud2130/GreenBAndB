/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.webcontrollers;

import co.edu.javeriana.ms.teentitans.Billing.models.Cart;
import co.edu.javeriana.ms.teentitans.Billing.models.Item;
import co.edu.javeriana.ms.teentitans.Billing.services.ICartService;

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
@RequestMapping("/carts")
public class CartController {
    @Autowired
    ICartService cartService;
    
    @GetMapping("/{id}")
    Cart getCartById(@PathVariable("id") String id){
        return cartService.getCartById(id);
    }
    
    @DeleteMapping("/{id}")
    void deleteCartById(@PathVariable("id") String id){
        cartService.deleteCartById(id);
    }
    
    @PostMapping("/{id}/item")
    Cart addCartItem(@PathVariable("id") String id, @RequestBody Item newItem){
        return cartService.addCartItem(id, newItem);
    }
    @DeleteMapping("/{id}/item/{id_service}")
    void deleteCartItem(@PathVariable("id") String id, @PathVariable("id_service") String idService){
        cartService.deleteCartItem(id, idService);
    }
    
    @PutMapping("/{id}/item")
    Cart setCartItemQuantity(@PathVariable("id") String id, @RequestBody Item item){
        return cartService.setCartItemQuantity(id, item.getId_service(), item.getQuantity());
    }
    
    @PostMapping("/{id}/pay")
    void payCart(@PathVariable("id") String id, @RequestParam("currency") String currency, @RequestParam("credit_card") String creditCard){
        cartService.payCart(id, currency, creditCard);
    }
}

