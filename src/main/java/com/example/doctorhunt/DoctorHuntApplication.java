package com.example.doctorhunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.doctorhunt")
public class DoctorHuntApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoctorHuntApplication.class, args);
    }
}
