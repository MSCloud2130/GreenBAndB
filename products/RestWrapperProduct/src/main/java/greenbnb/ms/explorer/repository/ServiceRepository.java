package greenbnb.ms.explorer.repository;
import greenbnb.ms.explorer.model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


import java.util.Optional;

/**
 * MongoRepository creates query based on functions names. 
 */
public interface ServiceRepository extends MongoRepository<Service, String>{
    
    public List<Service> findAll();
    public Optional<Service> findByName(String name);
    public Optional<Service> findById(String id);
    
}
