# syntax=docker/dockerfile:1

# --- Stage 1: сборка с Maven + JDK (multi-arch)
FROM maven:3.9.10-sapmachine-21 AS builder
WORKDIR /app

# скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# собираем приложение
COPY src ./src
RUN mvn clean package -DskipTests

# --- Stage 2: рантайм на базе Ubuntu Jammy (multi-arch)
FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal
WORKDIR /app

# копируем готовый JAR из builder’а
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]