package com.example.doctorhunt.dto;

import com.example.doctorhunt.dto.MedicalRecordDTO;

import java.util.List;

public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String location;
    private List<String> contactInfo;
    private String status;
    private List<MedicalRecordDTO> medicalRecords;

    // Default Constructor
    public PatientDTO() {
    }

    // Parameterized Constructor
    public PatientDTO(Long id, String firstName, String lastName, int age, String gender,
            String location, List<String> contactInfo, String status,
            List<MedicalRecordDTO> medicalRecords) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.contactInfo = contactInfo;
        this.status = status;
        this.medicalRecords = medicalRecords;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecordDTO> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "PatientDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                ", contactInfo=" + contactInfo +
                ", status='" + status + '\'' +
                ", medicalRecords=" + medicalRecords +
                '}';
    }
}
