package com.example.doctorhunt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String career;
    private String experience;
    private String speciality;

    @ElementCollection
    private Map<String, String> stories;

    private float rating;
    private boolean isFavourite;
    private int reviews;
    private BigDecimal hourRate;

    @ElementCollection
    private Map<String, String> timeSlot;

    @ElementCollection
    private Map<String, String> details;

    private boolean isFeatured;

    @ManyToMany
    @JoinTable(
        name = "doctor_patient",
        joinColumns = @JoinColumn(name = "doctor_id"),
        inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    @JsonIgnore  
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore  
    private List<Appointment> appointments;
}
