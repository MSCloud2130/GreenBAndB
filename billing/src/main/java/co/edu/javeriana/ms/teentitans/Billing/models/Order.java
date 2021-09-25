/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 *
 * @author estudiantes
 */
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id 
    private String id;
    private String idclient;
    private String credit_card;
    private Date String;
    private double total;
    private String currency;
    private List<Item> items;

    public Order(String idclient, String currency, String creditCard, List<Item> items) {
        
        this.idclient = idclient;
        this.currency = currency;
        this.idclient = creditCard;
        items= new ArrayList<>(items);
    }
}
