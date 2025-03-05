CREATE TABLE diagnosis_offers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    tests_offer INT,
    price DECIMAL(10, 2),
    services TEXT[],
    created_at TIMESTAMP DEFAULT NOW()
);
