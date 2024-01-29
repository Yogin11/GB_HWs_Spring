--Создание таблицы tasks в БД
CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description varchar(100) NOT NULL,
    status varchar(30) NOT NULL,
    created DATETIME default CURRENT_TIMESTAMP
);
-- Заполнение данными таблицы БД
INSERT INTO tasks (description, status) VALUES ('Пропылесосить до 20-00','NOT_STARTED');
INSERT INTO tasks (description, status) VALUES ('Продумать план следующей недели','IN_PROGRESS');
INSERT INTO tasks (description, status) VALUES ('Сделать изменения в своем проекте в соответствии с пройденным материалом','NOT_STARTED');
