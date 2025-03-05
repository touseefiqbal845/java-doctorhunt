package com.example.doctorhunt.controller;

import com.example.doctorhunt.model.MedicalRecord;
import com.example.doctorhunt.dto.PatientDTO;
import com.example.doctorhunt.dto.MedicalRecordDTO;
import com.example.doctorhunt.repository.MedicalRecordRepository;
import com.example.doctorhunt.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import com.example.doctorhunt.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;

    public MedicalRecordController(MedicalRecordRepository medicalRecordRepository,
            PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientRepository = patientRepository;
    }

    // Get medical record by ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> getMedicalRecordById(@PathVariable Long id) {
        Optional<MedicalRecord> medicalRecordOpt = medicalRecordRepository.findById(id);

        if (medicalRecordOpt.isPresent()) {
            MedicalRecord medicalRecord = medicalRecordOpt.get();

            // Convert MedicalRecord to MedicalRecordDTO
            MedicalRecordDTO dto = new MedicalRecordDTO();
            dto.setId(medicalRecord.getId());
            dto.setPrescription(medicalRecord.getPrescription());
            dto.setDate(medicalRecord.getDate());

            // Fetch patient associated with this medical record
            Patient patient = medicalRecord.getPatient();
            if (patient != null) {
                PatientDTO patientDTO = new PatientDTO();
                patientDTO.setId(patient.getId());
                patientDTO.setFirstName(patient.getFirstName());
                patientDTO.setLastName(patient.getLastName());
                patientDTO.setAge(patient.getAge());
                patientDTO.setGender(patient.getGender());
                patientDTO.setLocation(patient.getLocation());
                patientDTO.setContactInfo(patient.getContactInfo());
                patientDTO.setStatus(patient.getStatus());

                // Set the patientDTO in the MedicalRecordDTO
                dto.setPatient(patientDTO);
            }

            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get medical records by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordsByPatient(@PathVariable Long patientId) {
        Optional<List<MedicalRecord>> medicalRecords = Optional
                .ofNullable(medicalRecordRepository.findByPatientId(patientId));

        return medicalRecords.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new medical record
    @PostMapping("/add")
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        Optional<Patient> patientOpt = patientRepository.findById(medicalRecord.getPatient().getId());
        if (patientOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        medicalRecord.setPatient(patientOpt.get());
        return ResponseEntity.ok(medicalRecordRepository.save(medicalRecord));
    }

    // Update medical record
    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long id,
            @RequestBody MedicalRecord updatedRecord) {
        return medicalRecordRepository.findById(id).map(record -> {
            record.setPrescription(updatedRecord.getPrescription());
            record.setDate(updatedRecord.getDate());
            return ResponseEntity.ok(medicalRecordRepository.save(record));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete medical record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        if (!medicalRecordRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        medicalRecordRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
