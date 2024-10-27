# Step 1: Build the frontend
FROM node:18 AS frontend-build
WORKDIR /app

# Copy package files first for better caching
COPY src/main/frontend/package*.json ./
RUN npm install

# Copy the frontend files
COPY src/main/frontend/ ./
COPY src/main/resources/ ./resources/

RUN npm run build

# Step 2: Build the Spring Boot application
FROM maven:3.9.9-eclipse-temurin-23 AS spring-build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Copy the frontend build output
COPY --from=frontend-build /app/resources/static/css/main.css /app/src/main/resources/static/css/main.css

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Step 3: Create the final image
FROM eclipse-temurin:23-alpine
WORKDIR /app

# Copy the built JAR file from the Spring Boot stage
COPY --from=spring-build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
