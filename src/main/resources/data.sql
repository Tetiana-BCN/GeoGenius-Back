
    -- Create table (optional if Hibernate manages schema with spring.jpa.hibernate.ddl-auto=update)
CREATE TABLE IF NOT EXISTS countries (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    capital VARCHAR(100) NOT NULL
);


-- Insert countries data
INSERT INTO countries (name, capital) VALUES
('Albania', 'Tirana'),
('Andorra', 'Andorra la Vella'),
('Armenia', 'Yerevan'),
('Austria', 'Vienna'),
('Azerbaijan', 'Baku'),
('Belarus', 'Minsk'),
('Belgium', 'Brussels'),
('Bosnia and Herzegovina', 'Sarajevo'),
('Bulgaria', 'Sofia'),
('Croatia', 'Zagreb');