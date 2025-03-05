package com.example.doctorhunt.dto;

import java.util.Date;

public class MedicalRecordDTO {
    private Long id;
    private String prescription;
    private Date date;
    private PatientDTO patient;

    public MedicalRecordDTO() {
    }

    public MedicalRecordDTO(Long id, Date date, String prescription) {
        this.id = id;
        this.date = date;
        this.prescription = prescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
}
