CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT,
    gender VARCHAR(50),
    location VARCHAR(255),
    contact_info JSONB
);
