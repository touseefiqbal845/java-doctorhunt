    package com.example.doctorhunt.model;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;
    import com.fasterxml.jackson.annotation.JsonIgnore;

    import java.util.Date;

    @Entity
    @Getter
    @Setter
    @Table(name = "medical_records")
    public class MedicalRecord {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "patient_id")
        private Patient patient;

        private String prescription;

        @Temporal(TemporalType.DATE)
        private Date date;
    }
