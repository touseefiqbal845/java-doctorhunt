package com.example.doctorhunt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String location;

    @ElementCollection
    private List<String> contactInfo;

    @ManyToMany(fetch = FetchType.LAZY)  // Ensure correct fetching
    @JoinTable(name = "patient_doctor",
               joinColumns = @JoinColumn(name = "patient_id"),
               inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    @JsonProperty("status")
    private String status = "Active";  
}
