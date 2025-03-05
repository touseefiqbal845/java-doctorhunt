package com.example.doctorhunt.repository;

import com.example.doctorhunt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndResetPasswordToken(String email, String resetPasswordToken);
}
