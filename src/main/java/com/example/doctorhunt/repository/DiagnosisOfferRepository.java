package com.example.doctorhunt.repository;

import com.example.doctorhunt.model.DiagnosisOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiagnosisOfferRepository extends JpaRepository<DiagnosisOffer, Long> {
    List<DiagnosisOffer> findByNameContaining(String name);
}
