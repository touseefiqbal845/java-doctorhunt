CREATE TABLE appointments (
    id SERIAL PRIMARY KEY,
    patient_id BIGINT REFERENCES patients(id),
    doctor_id BIGINT REFERENCES doctors(id),
    time TIME,
    date DATE,
    location JSONB,
    status VARCHAR(20) CHECK (status IN ('pending', 'confirmed', 'completed', 'cancelled')) DEFAULT 'pending'
);
