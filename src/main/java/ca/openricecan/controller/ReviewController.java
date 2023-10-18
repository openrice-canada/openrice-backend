package ca.openricecan.controller;

import ca.openricecan.data.entity.review.ReviewEntity;
import ca.openricecan.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public Iterable<ReviewEntity> gerReviewList() {
        return reviewService.getAllReviews();
    }
}
