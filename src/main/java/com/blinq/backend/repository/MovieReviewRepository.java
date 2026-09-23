package com.blinq.backend.repository;

import com.blinq.backend.model.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
    // Spring Boot literally writes the SQL for this based on the method name
    List<MovieReview> findByTmdbMovieIdOrderByCreatedAtDesc(Long tmdbMovieId);
}