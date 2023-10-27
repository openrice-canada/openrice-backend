package ca.openricecan.controller;

import ca.openricecan.model.entity.review.ReviewEntity;
import ca.openricecan.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
  private final ReviewService reviewService;

  @Autowired
  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping
  public Iterable<ReviewEntity> gerReviewList(
          @RequestParam(required = false) UUID restaurantId
  ) {
    return reviewService.getAllReviews(restaurantId);
  }

  @GetMapping(path = "{id}")
  public ReviewEntity getReviewById(@PathVariable UUID id) {
    return reviewService.getReviewById(id);
  }

  @PostMapping
  public ReviewEntity addReview(@RequestBody ReviewEntity reviewEntity) {
    return reviewService.addReview(reviewEntity);
  }

  @PutMapping(path = "{id}")
  public ReviewEntity editReview(@PathVariable UUID id, @RequestBody ReviewEntity reviewEntity) {
    return reviewService.editReview(id, reviewEntity);
  }

  @DeleteMapping(path = "{id}")
  public ReviewEntity deleteReview(@PathVariable UUID id) {
    return reviewService.deleteReview(id);
  }
}
