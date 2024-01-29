# Разработка приложения для управления проектами

## Микросервис связывания пользователей с проектами

Реализовано в REST представлении.

Основные сущности: Пользователь и Проект.

Пользователь имеет следующие поля:

- Идентификатор (id) типа Long, генерируемый автоматически при создании записи.
- Имя пользователя (username) типа String.
- Пароль (password) типа String.
- Электронная почта (email) типа String.
- Роль (role) типа String.

Проект имеет следующие поля:

- Идентификатор (id) типа Long, генерируемый автоматически при создании записи.
- Название проекта (name) типа String.
- Описание проекта (description) типа String.
- Дата создания (createdDate) типа LocalDate.

Сущности связаны между собой промежуточным классом "Пользователь-Проект" (UsersProject), реализующим связь многие-ко-многим.  

В сервисе с помощью базы данных H2 инициализированы несколько пользователей, проектов и связи между ними 
для симуляции работы сервиса.

Функционал:

1. Запросы по пользователям:
    - <span style="color:#59afe1">localhost:8080/users </span> - метод GET покажет всех пользователей;
    - <span style="color:#59afe1">localhost:8080/users/2 </span> - метод GET покажет пользователя с id=2;
    - <span style="color:#59afe1">localhost:8080/users </span> - метод POST создаст нового пользователя
      из тела запроса;
    - <span style="color:#59afe1">localhost:8080/users/1 </span>- метод PUT обновит данные пользователя с id=1
      данными из тела запроса;
    - <span style="color:#59afe1">localhost:8080/users/1 </span>- метод DELETE удалит пользователя с id=1;


2. Запросы по проектам:
    - <span style="color:#59afe1"> localhost:8080/projects </span> - метод GET покажет все проекты;
    - <span style="color:#59afe1">localhost:8080/projects/2 </span>- метод GET покажет проекты с id = 2;
    - <span style="color:#59afe1">localhost:8080/projects </span>- метод POST создаст новый проект из тела запроса;
    - <span style="color:#59afe1">localhost:8080/projects/1 </span>- метод PUT обновит данные проекта с id = 1
      данными из тела запроса;
    - <span style="color:#59afe1">localhost:8080/projects/1 </span>- метод DELETE удалит проект с id = 1;


3. Запросы связанные с пользователями и проектами:
    - <span style="color:#59afe1">localhost:8080/user_project/users/4 </span> -
      метод GET выводит список проектов, связанных с пользователем с id=4
    - <span style="color:#59afe1">localhost:8080/user_project/projects/2 </span> -
      метод GET выводит список пользователей, связанных с проектом с id=2
    - <span style="color:#59afe1">localhost:8080/user_project/projects/2/1 </span> -
      метод POST добавляет в проект с id=2 пользователя с id=1
    - <span style="color:#59afe1">localhost:8080/user_project/projects/1/3 </span> - 
    метод DELETE удаляет из проекта с id=2 пользователя с id=3