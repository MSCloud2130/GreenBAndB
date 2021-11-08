package greenbnb.ms.explorer.repository;

import greenbnb.ms.explorer.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {
    Optional<Review> findById(String id);
    List<Review> findByServiceId(String id_service);
}
