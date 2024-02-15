CREATE TABLE IF NOT EXISTS users_project(
    id INT AUTO_INCREMENT PRIMARY KEY,
    related_entity_id LONG DEFAULT 1,
    project_id LONG NOT NULL,
    user_id LONG NOT NULL
--     FOREIGN KEY (project_id) REFERENCES projects (id) ON  DELETE CASCADE,
--     FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
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
