/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.repositories;

import co.edu.javeriana.ms.teentitans.Billing.models.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicolas Camacho Plazas
 */

@Repository
public interface CartRepository extends MongoRepository <Cart, String> {}
