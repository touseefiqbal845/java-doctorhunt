package com.example.doctorhunt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    @ElementCollection
    private Map<String, String> location;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public enum Status {
        PENDING, CONFIRMED, COMPLETED, CANCELLED
    }
}
