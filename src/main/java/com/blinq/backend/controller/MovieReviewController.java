package com.blinq.backend.controller;

import com.blinq.backend.model.MovieReview;
import com.blinq.backend.repository.MovieReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:5173")
public class MovieReviewController {

    private final MovieReviewRepository reviewRepository;

    public MovieReviewController(MovieReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Fetch all reviews for a specific TMDB Movie ID
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<MovieReview>> getReviewsForMovie(@PathVariable Long movieId) {
        List<MovieReview> reviews = reviewRepository.findByTmdbMovieIdOrderByCreatedAtDesc(movieId);
        return ResponseEntity.ok(reviews);
    }

    // Submit a new review
    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody MovieReview review) {
        if (review.getRating() < 1 || review.getRating() > 5) {
            return ResponseEntity.badRequest().body("Rating must be between 1 and 5 stars.");
        }
        MovieReview savedReview = reviewRepository.save(review);
        return ResponseEntity.ok(savedReview);
    }

    // Admin only: Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        if (!reviewRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        reviewRepository.deleteById(id);
        return ResponseEntity.ok().body("Review deleted successfully.");
    }
}