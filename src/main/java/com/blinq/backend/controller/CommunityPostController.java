package com.blinq.backend.controller;

import com.blinq.backend.model.CommunityPost;
import com.blinq.backend.repository.CommunityPostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class CommunityPostController {

    private final CommunityPostRepository repository;

    public CommunityPostController(CommunityPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CommunityPost> getAllPosts() {
        return repository.findAll();
    }

    @PostMapping
    public CommunityPost createPost(@RequestBody CommunityPost post) {
        return repository.save(post);
    }
}