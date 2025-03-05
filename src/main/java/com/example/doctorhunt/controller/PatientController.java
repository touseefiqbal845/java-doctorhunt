package com.example.doctorhunt.controller;

import com.example.doctorhunt.dto.PatientDTO;
import com.example.doctorhunt.model.Patient;
import com.example.doctorhunt.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.doctorhunt.dto.MedicalRecordDTO;


import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(this::convertToDTO)
                      .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @PostMapping
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = convertToEntity(patientDTO);
        Patient savedPatient = patientService.savePatient(patient);
        return convertToDTO(savedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    private PatientDTO convertToDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setGender(patient.getGender());
        patientDTO.setLocation(patient.getLocation());
        patientDTO.setContactInfo(patient.getContactInfo());
        patientDTO.setStatus(patient.getStatus());
    
        if (patient.getMedicalRecords() != null) {
            patientDTO.setMedicalRecords(patient.getMedicalRecords().stream()
                .map(record -> new MedicalRecordDTO(
                    record.getId(), 
                    record.getDate(), 
                    record.getPrescription()
                ))
                .collect(Collectors.toList()));  
        }
    
        return patientDTO;
    }
    
    private Patient convertToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());
        patient.setLocation(patientDTO.getLocation());
        patient.setContactInfo(patientDTO.getContactInfo());
        patient.setStatus(patientDTO.getStatus());
        return patient;
    }
}
