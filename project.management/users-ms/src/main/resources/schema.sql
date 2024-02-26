CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(8) NOT NULL,
    email VARCHAR(30),
    role VARCHAR(15)
    );
-- Заполнение данными таблицы users
INSERT INTO users (name, password, email, role) VALUES ('Alexander', '123', 'alex@ya.ru', 'Teamlead');
INSERT INTO users (name, password, email, role) VALUES ('Sergey', '777', 'serg@yahoo.ru', 'Developer');
INSERT INTO users (name, password, email, role) VALUES ('Pavel', '123', 'pavel@mail.ru', 'Devops');
INSERT INTO users (name, password, email, role) VALUES ('Olga', '564', 'olga@co.ru', 'Designer');
INSERT INTO users (name, password, email, role) VALUES ('Vladlen', '999', 'vladlen@gmail.com', 'Developer');