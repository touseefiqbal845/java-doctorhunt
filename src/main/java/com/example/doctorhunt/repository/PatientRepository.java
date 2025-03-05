package com.example.doctorhunt.repository;

import com.example.doctorhunt.model.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @EntityGraph(attributePaths = {"doctors", "medicalRecords", "appointments"})
    Optional<Patient> findById(Long id);

    @Query("SELECT p FROM Patient p " +
           "LEFT JOIN FETCH p.medicalRecords " +
           "WHERE p.id = :id")
    Optional<Patient> findByIdWithDetails(@Param("id") Long id);
}
