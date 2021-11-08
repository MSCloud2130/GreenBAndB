package greenbnb.ms.explorer.service;

import greenbnb.ms.explorer.model.Review;
import greenbnb.ms.explorer.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ReviewRepository repository;

    public ProductsService(ReviewRepository repository){
        this.repository = repository;
    }

    public Review createReviewForService(Review review){
        return repository.save(review);
    }

    public List<Review> getByIdService(String id_service) {
       return repository.findByServiceId(id_service);
    }

    public Optional<Review> getById(String id){
        return repository.findById(id);
    }

    public void deleteReviewById(String id_review) {
        repository.deleteById(id_review);
    }
}
