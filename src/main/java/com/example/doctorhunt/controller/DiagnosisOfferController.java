package com.example.doctorhunt.controller;

import com.example.doctorhunt.model.DiagnosisOffer;
import com.example.doctorhunt.repository.DiagnosisOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diagnosis-offers")
public class DiagnosisOfferController {

    @Autowired
    private DiagnosisOfferRepository diagnosisOfferRepository;

    // Get all diagnosis offers
    @GetMapping
    public List<DiagnosisOffer> getAllDiagnosisOffers() {
        return diagnosisOfferRepository.findAll();
    }

    // Get diagnosis offer by ID
    @GetMapping("/{id}")
    public ResponseEntity<DiagnosisOffer> getDiagnosisOfferById(@PathVariable("id") Long id) {
        Optional<DiagnosisOffer> diagnosisOffer = diagnosisOfferRepository.findById(id);
        return diagnosisOffer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new diagnosis offer
    @PostMapping
    public ResponseEntity<DiagnosisOffer> createDiagnosisOffer(@RequestBody DiagnosisOffer diagnosisOffer) {
        DiagnosisOffer savedOffer = diagnosisOfferRepository.save(diagnosisOffer);
        return new ResponseEntity<>(savedOffer, HttpStatus.CREATED);
    }

    // Update an existing diagnosis offer
    @PutMapping("/{id}")
    public ResponseEntity<DiagnosisOffer> updateDiagnosisOffer(@PathVariable("id") Long id, @RequestBody DiagnosisOffer diagnosisOffer) {
        if (!diagnosisOfferRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        diagnosisOffer.setId(id);
        DiagnosisOffer updatedOffer = diagnosisOfferRepository.save(diagnosisOffer);
        return ResponseEntity.ok(updatedOffer);
    }

    // Delete a diagnosis offer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnosisOffer(@PathVariable("id") Long id) {
        if (!diagnosisOfferRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        diagnosisOfferRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Search diagnosis offers by name (partial match)
    @GetMapping("/search")
    public List<DiagnosisOffer> searchDiagnosisOffers(@RequestParam("name") String name) {
        return diagnosisOfferRepository.findByNameContaining(name);
    }
}
