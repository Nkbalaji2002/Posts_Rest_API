# --- Stage 1: Build the JAR ---
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build Spring Boot fat JAR
RUN mvn clean package -DskipTests

# --- Stage 2: Run the JAR ---
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]