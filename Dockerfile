# syntax=docker/dockerfile:1

# --- Stage 1: сборка — у нас есть Maven + JDK
FROM maven:3.9.0-openjdk-17 AS builder
WORKDIR /app

# Сначала копируем только pom.xml и скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходники и собираем
COPY src ./src
RUN mvn clean package -DskipTests

# --- Stage 2: рантайм, только JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Копируем готовый JAR из builder-стейджа
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]