package com.example.doctorhunt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "diagnosis_offers")
public class DiagnosisOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Integer testsOffer;
    private BigDecimal price;

    @ElementCollection
    private List<String> services; 

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

}
