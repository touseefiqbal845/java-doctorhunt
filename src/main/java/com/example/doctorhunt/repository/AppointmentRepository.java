    package com.example.doctorhunt.repository;

    import com.example.doctorhunt.model.Appointment;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    }
