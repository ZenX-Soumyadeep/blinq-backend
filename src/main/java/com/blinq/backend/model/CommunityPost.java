package com.blinq.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "community_posts")
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    private int upvotes = 0;

    private int comments = 0;

    private LocalDateTime createdAt = LocalDateTime.now();
}