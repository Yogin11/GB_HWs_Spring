CREATE TABLE IF NOT EXISTS projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_date DATE default CURRENT_DATE
    );
-- Заполнение данными таблицы projects
INSERT INTO projects (name, description) VALUES ('Secret project', 'Investigation of some competitors program' );
INSERT INTO projects (name, description) VALUES ('Project A', 'Creation of site dedicated to the movie with starring Jackie Chan' );
INSERT INTO projects (name, description) VALUES ('Festival event', 'VDNkH festival web advertisement developemnt' );
