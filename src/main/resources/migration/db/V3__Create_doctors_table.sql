CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    career VARCHAR(255),
    experience VARCHAR(255),
    speciality VARCHAR(255),
    rating FLOAT DEFAULT 0,
    is_favourite BOOLEAN DEFAULT FALSE,
    reviews INT DEFAULT 0,
    hour_rate DECIMAL(10, 2),
    time_slot JSONB,
    details JSONB,
    is_featured BOOLEAN DEFAULT FALSE
);
