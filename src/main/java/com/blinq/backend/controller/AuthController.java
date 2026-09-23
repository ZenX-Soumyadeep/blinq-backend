package com.blinq.backend.controller;

import com.blinq.backend.model.User;
import com.blinq.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Anti-bot & duplicate check
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email is already in use.");
        }
        if (userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Phone number is already registered.");
        }

        // Force default role to USER unless they are explicitly created as an ADMIN
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        // Find user by email
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        // Check if user exists and password matches (plaintext for this prototype)
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(401).body("Error: Invalid email or password.");
    }
}