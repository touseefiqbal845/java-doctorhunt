CREATE TABLE doctor_patient (
    doctor_id BIGINT REFERENCES doctors(id),
    patient_id BIGINT REFERENCES patients(id),
    PRIMARY KEY (doctor_id, patient_id)
);
