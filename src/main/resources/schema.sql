CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age INTEGER NOT NULL,
    email varchar(50) NOT NULL
);
INSERT INTO users (name, age, email) VALUES ('Vasiliy',35,'vasiliy@ya.ru');
INSERT INTO users (name, age, email) VALUES ('Fedor',30,'fedor@ti.ru');
INSERT INTO users (name, age, email) VALUES ('On',45,'on@on.ru');

