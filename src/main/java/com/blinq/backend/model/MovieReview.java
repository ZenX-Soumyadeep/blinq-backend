package com.blinq.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movie_reviews")
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long tmdbMovieId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private int rating; // 1 to 5 stars

    @Column(columnDefinition = "TEXT", nullable = false)
    private String reviewText;

    private LocalDateTime createdAt = LocalDateTime.now();
}