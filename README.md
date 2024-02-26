# Разработка микросервисов для управления проектами

## Микросервисы: 

1) Облачный конфигуратор (cloud_config)
2) Eureka сервер (eureka_server)
3) Api-Gateway сервис (api-gateway)
4) Пользователи (users-ms)
5) Проекты (projects-microservice)
6) Пользователь-проект (user-project-ms)
7) Web представление (web-proj-service)

Запуск осуществляется в указанном выше порядке, либо запустить конфигурацию (в IntelliJIDEA) "AllProject".

## Описание проекта

Реализовано в REST и WEB представлениях.

Основные сущности: "Пользователь" и "Проект".

"Пользователь" имеет следующие поля:

- Идентификатор (id) типа Long, генерируемый автоматически при создании записи.
- Имя пользователя (username) типа String.
- Пароль (password) типа String.
- Электронная почта (email) типа String.
- Роль (role) типа String.

"Проект" имеет следующие поля:

- Идентификатор (id) типа Long, генерируемый автоматически при создании записи.
- Название проекта (name) типа String.
- Описание проекта (description) типа String.
- Дата создания (createdDate) типа LocalDate.

В микросервисах с помощью баз данных H2 инициализированы несколько пользователей, проектов и связи между ними 
для симуляции работы микросервисов.

Микросервисы работают на базе Spring Cloud, реализованы сервер обнаружения Eureka (eureka-server) и маршрутизатор API Gateway (project.management).

Микросервис "пользователь-проект" использует Spring Cloud Open Feign.

Конфигурации микросервисов загружаются из внешнего репозитория на Github.

Функционал REST сервисов:

1. Микросервис "Пользователи". Запросы по пользователям:
    - <span style="color:#59afe1">localhost:8081/users </span> - метод GET покажет всех пользователей;
    - <span style="color:#59afe1">localhost:8081/users/2 </span> - метод GET покажет пользователя с id=2;
    - <span style="color:#59afe1">localhost:8081/users </span> - метод POST создаст нового пользователя
      из тела запроса;
    - <span style="color:#59afe1">localhost:8081/users/1 </span>- метод PUT обновит данные пользователя с id=1
      данными из тела запроса;
    - <span style="color:#59afe1">localhost:8081/users/1 </span>- метод DELETE удалит пользователя с id=1;


2. Микросервис "Проекты". Запросы по проектам:
    - <span style="color:#59afe1"> localhost:8082/projects </span> - метод GET покажет все проекты;
    - <span style="color:#59afe1">localhost:8082/projects/2 </span>- метод GET покажет проекты с id = 2;
    - <span style="color:#59afe1">localhost:8082/projects </span>- метод POST создаст новый проект из тела запроса;
    - <span style="color:#59afe1">localhost:8082/projects/1 </span>- метод PUT обновит данные проекта с id = 1
      данными из тела запроса;
    - <span style="color:#59afe1">localhost:8082/projects/1 </span>- метод DELETE удалит проект с id = 1;


3. Микросервис "Пользователи-проекты". Запросы связанные с пользователями и проектами:
    - <span style="color:#59afe1">localhost:8083/user_project/users/4 </span> -
      метод GET выводит список проектов, связанных с пользователем с id=4
    - <span style="color:#59afe1">localhost:8083/user_project/projects/2 </span> -
      метод GET выводит список пользователей, связанных с проектом с id=2
    - <span style="color:#59afe1">localhost:8083/user_project/projects/2/1 </span> -
      метод POST добавляет в проект с id=2 пользователя с id=1
    - <span style="color:#59afe1">localhost:8083/user_project/projects/1/3 </span> - 
      метод DELETE удаляет из проекта с id=2 пользователя с id=3

Микросервисы работают через маршрутизатор API Gateway. Его адрес localhost:8765, поэтому все запросы из пунктов 1-3 можно отправлять с порта 8765, а не  8081, 8082 и 8083.
Просмотр зарегистрированных сервисов и их обнаружение на сервере Eureka доступно по адресу localhost:8761.