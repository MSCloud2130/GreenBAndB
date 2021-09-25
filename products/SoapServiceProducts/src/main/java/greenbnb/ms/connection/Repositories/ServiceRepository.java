package greenbnb.ms.connection.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import greenbnb.ms.connection.Entities.Service;
import java.util.Optional;

/**
 * MongoRepository creates query based on functions names. 
 */
public interface ServiceRepository extends MongoRepository<Service, Integer>{
    
    public Optional<Service> findByServiceId(String serviceId);
    public List<Service> findAll();
    public List<Service> findBySupplierId(String supplierId);
    
}
