/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.repositories;

import co.edu.javeriana.ms.teentitans.Billing.models.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author estudiantes
 */

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByIdclient(String idclient);
    Optional<Order> findByIdclientAndId(String idclient, String id);
}
