package com.example.doctorhunt.repository;

import com.example.doctorhunt.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
