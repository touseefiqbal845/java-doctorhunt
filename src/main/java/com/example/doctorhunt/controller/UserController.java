package com.example.doctorhunt.controller;

import com.example.doctorhunt.model.User;
import com.example.doctorhunt.repository.UserRepository;
import com.example.doctorhunt.service.JwtService;
import com.example.doctorhunt.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailService emailService;

    // ✅ Register User
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody User user) {
        try {
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Email already exists"));
            }
    
            user.setPassword(passwordEncoder.encode(user.getPassword())); 
            userRepository.save(user);
    
            return ResponseEntity.ok(Map.of("message", "User created successfully"));
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception details
            return ResponseEntity.status(500).body(Map.of("error", "Internal Server Error", "details", e.getMessage()));
        }
    }
    

    // ✅ Login User
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Map<String, String> loginRequest) {
        Optional<User> userOpt = userRepository.findByEmail(loginRequest.get("email"));

        if (userOpt.isPresent() && passwordEncoder.matches(loginRequest.get("password"), userOpt.get().getPassword())) {
           String token = jwtService.generateToken(String.valueOf(userOpt.get().getId()));
            return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "token", token,
                "user", Map.of("id", userOpt.get().getId(), "role", userOpt.get().getRole())
            ));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid email or password"));
    }

    // ✅ Logout (Handled client-side)
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logoutUser() {
        return ResponseEntity.ok(Map.of("message", "Logged out successfully"));
    }

    // ✅ Check Authentication (Requires token in request header)
    @GetMapping("/check-auth")
    public ResponseEntity<Map<String, Object>> checkAuth(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("error", "Missing or invalid token"));
        }

        String token = authHeader.substring(7); // Remove "Bearer " prefix
        if (jwtService.validateToken(token)) {
            Long userId = jwtService.extractUserId(token);
            return ResponseEntity.ok(Map.of("message", "User authenticated", "userId", userId));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Unauthorized"));
    }

    // ✅ Request Password Reset
    @PostMapping("/reset-password-request")
    public ResponseEntity<Map<String, Object>> resetPasswordRequest(@RequestBody Map<String, String> request) {
        Optional<User> userOpt = userRepository.findByEmail(request.get("email"));

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("error", "User not found"));
        }

        User user = userOpt.get();
        String resetToken = UUID.randomUUID().toString();
        user.setResetPasswordToken(passwordEncoder.encode(resetToken)); 
        userRepository.save(user);

        emailService.sendResetPasswordEmail(user.getEmail(), resetToken);
        return ResponseEntity.ok(Map.of("message", "Password reset email sent"));
    }

    // ✅ Reset Password
    @PostMapping("/reset-password")
    public ResponseEntity<Map<String, Object>> resetPassword(@RequestBody Map<String, String> request) {
        Optional<User> userOpt = userRepository.findByEmail(request.get("email"));

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(request.get("token"), user.getResetPasswordToken())) {
                user.setPassword(passwordEncoder.encode(request.get("password")));
                user.setResetPasswordToken(null); // Clear token after reset
                userRepository.save(user);
                return ResponseEntity.ok(Map.of("message", "Password reset successfully"));
            }
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid token or email"));
    }
}
