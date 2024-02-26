CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    email VARCHAR(30),
    role VARCHAR(15)
    );
-- Заполнение данными таблицы users
INSERT INTO users (name, surname, email, role) VALUES ('Alexander', 'Petrov', 'alex@ya.ru', 'Teamlead');
INSERT INTO users (name, surname, email, role) VALUES ('Sergey', 'Mikarev', 'serg@yahoo.ru', 'Developer');
INSERT INTO users (name, surname, email, role) VALUES ('Pavel', 'Ionov', 'pavel@mail.ru', 'Devops');
INSERT INTO users (name, surname, email, role) VALUES ('Olga', 'Makarova', 'olga@co.ru', 'Designer');
INSERT INTO users (name, surname, email, role) VALUES ('Vladlen', 'Vlasov', 'vladlen@gmail.com', 'Developer');