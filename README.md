# TroodExampleServise API

## Описание
REST API для управления проектами и вакансиями. Используется Spring Boot, H2 (in-memory), JPA, валидация.

## Деплой и тестирование

**Ссылка на задеплоенное приложение:** [https://trood.rocket-champ.com/swagger-ui/index.html](https://trood.rocket-champ.com/swagger-ui/index.html)

**Инструкции по тестированию:**

Для тестирования API можно использовать Swagger UI, который доступен по ссылке выше.

1.  **Swagger UI:** Откройте [https://trood.rocket-champ.com/swagger-ui/index.html](https://trood.rocket-champ.com/swagger-ui/index.html) в вашем браузере.
2.  **Эндпоинты:** В Swagger UI вы найдете все доступные эндпоинты для проектов и вакансий.
3.  **Примеры запросов:** Вы можете использовать примеры запросов ниже для тестирования через `curl` или любой другой HTTP-клиент.

## Примеры запросов

### Создать проект
```bash
curl -X POST https://trood.rocket-champ.com/projects -H 'Content-Type: application/json' -d '{"name":"Demo Project","description":"Описание"}'
```

### Получить проекты
```bash
curl https://trood.rocket-champ.com/projects
```

### Добавить вакансию
```bash
curl -X POST https://trood.rocket-champ.com/projects/1/vacancies -H 'Content-Type: application/json' -d '{"title":"Java Dev","description":"Spring"}'
```

## Эндпоинты

### Проекты
- `GET /projects` — список проектов
- `POST /projects` — создать проект
- `PUT /projects/{id}` — редактировать проект
- `DELETE /projects/{id}` — удалить проект

### Вакансии
- `GET /projects/{id}/vacancies` — список вакансий проекта
- `POST /projects/{id}/vacancies` — добавить вакансию к проекту
- `PUT /vacancies/{id}` — редактировать вакансию
- `DELETE /vacancies/{id}` — удалить вакансию

## Локальный запуск

### Через Docker
1. Соберите jar:
   ```bash
   ./mvnw clean package -DskipTests
   ```
2. Соберите Docker-образ:
   ```bash
   docker build -t trood-example-api .
   ```
3. Запустите контейнер:
   ```bash
   docker run -p 8080:8080 trood-example-api
   ```
4. API будет доступен на http://localhost:8080

### Без Docker
1. Установите Java 21 и Maven.
2. Склонируйте репозиторий.
3. Запустите приложение:
   ```bash
   ./mvnw spring-boot:run
   ```
4. API будет доступен на http://localhost:8080

**Swagger UI для локального запуска:** http://localhost:8080/swagger-ui.html

## H2 Console (только для локального запуска)
Для доступа к in-memory базе данных H2:
- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (пустой)

## Технологии и версии
- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Validation
- H2 Database
- Lombok
- Swagger (springdoc-openapi) 2.5.0
- Maven
