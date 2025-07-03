# TroodExampleServise API

## Описание
REST API для управления проектами и вакансиями. Используется Spring Boot, H2 (in-memory), JPA, валидация.

## Быстрый старт (Docker)

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
5. Swagger UI: http://localhost:8080/swagger-ui.html

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

## Примеры запросов

### Создать проект
```bash
curl -X POST http://localhost:8080/projects -H 'Content-Type: application/json' -d '{"name":"Demo Project","description":"Описание"}'
```

### Получить проекты
```bash
curl http://localhost:8080/projects
```

### Добавить вакансию
```bash
curl -X POST http://localhost:8080/projects/1/vacancies -H 'Content-Type: application/json' -d '{"title":"Java Dev","description":"Spring"}'
```

## Мок-данные для теста

```json
{
  "name": "Test Project",
  "description": "Описание проекта"
}
```

```json
{
  "title": "Backend Developer",
  "description": "Java, Spring Boot"
}
```

## Технологии
- Spring Boot
- Spring Data JPA
- Spring Validation
- H2 Database
- Lombok
- Swagger (springdoc-openapi)
- Docker

## H2 Console
http://localhost:8080/h2-console
JDBC URL: `jdbc:h2:mem:testdb`

---

**Деплой:** стандартный Spring Boot jar, можно деплоить на любой сервер с Java 17+ или через Docker (см. выше). 