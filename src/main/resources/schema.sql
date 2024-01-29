CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(8) NOT NULL,
    email VARCHAR(30),
    role VARCHAR(15)
);
-- Заполнение данными таблицы users
INSERT INTO users (name, password, email, role) VALUES ('Alexander', '123', 'alex@ya.ru', 'Teamlead');
INSERT INTO users (name, password, email, role) VALUES ('Sergey', '123', 'serg@yahoo.ru', 'Developer');
INSERT INTO users (name, password, email, role) VALUES ('Pavel', '123', 'pavel@mail.ru', 'Devops');
INSERT INTO users (name, password, email, role) VALUES ('Olga', '123', 'olga@co.ru', 'Designer');
INSERT INTO users (name, password, email, role) VALUES ('Vladlen', '123', 'vladlen@gmail.com', 'Developer');

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

CREATE TABLE IF NOT EXISTS users_project (
    id INT AUTO_INCREMENT PRIMARY KEY,
    related_entity_id LONG DEFAULT 1,
    project_id LONG NOT NULL,
    user_id LONG NOT NULL,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON  DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO users_project (project_id, user_id) VALUES (1,1);
INSERT INTO users_project (project_id, user_id) VALUES (1,2);
INSERT INTO users_project (project_id, user_id) VALUES (1,3);
INSERT INTO users_project (project_id, user_id) VALUES (2,1);
INSERT INTO users_project (project_id, user_id) VALUES (2,4);
INSERT INTO users_project (project_id, user_id) VALUES (3,1);
INSERT INTO users_project (project_id, user_id) VALUES (3,2);
INSERT INTO users_project (project_id, user_id) VALUES (3,4);
INSERT INTO users_project (project_id, user_id) VALUES (3,5);

