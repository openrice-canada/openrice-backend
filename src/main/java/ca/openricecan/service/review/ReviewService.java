package ca.openricecan.service.review;

import ca.openricecan.model.entity.review.ReviewEntity;
import ca.openricecan.repository.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Iterable<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }
}
