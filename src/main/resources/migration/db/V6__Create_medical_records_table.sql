CREATE TABLE medical_records (
    id SERIAL PRIMARY KEY,
    patient_id BIGINT REFERENCES patients(id),
    prescription TEXT,
    date DATE
);
