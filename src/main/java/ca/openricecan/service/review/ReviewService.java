package ca.openricecan.service.review;

import ca.openricecan.model.entity.review.ReviewEntity;
import ca.openricecan.repository.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewService {
  private final ReviewRepository reviewRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public Iterable<ReviewEntity> getAllReviews(UUID restaurantId) {
    if (restaurantId == null) {
      return reviewRepository
              .findAll()
              .stream()
              .toList();
    }
    return reviewRepository
            .findAll()
            .stream()
            .filter(restaurant -> restaurant.getRestaurantId().equals(restaurantId))
            .toList();
  }

  public ReviewEntity getReviewById(UUID id) {
    return reviewRepository.findById(id).orElse(null);
  }

  public ReviewEntity addReview(ReviewEntity reviewEntity) {
    return reviewRepository.save(reviewEntity);
  }

  public ReviewEntity editReview(UUID id, ReviewEntity reviewEntity) {
    return reviewRepository.findById(id).map(review -> {
      reviewEntity.setReviewId(id);
      return reviewRepository.save(reviewEntity);
    }).orElse(null);
  }

  public ReviewEntity deleteReview(UUID id) {
    return reviewRepository.findById(id).map(review -> {
      review.setActive(false);
      return reviewRepository.save(review);
    }).orElse(null);
  }
}
