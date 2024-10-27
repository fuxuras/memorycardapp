# Step 1: Build the frontend
FROM node:18 AS frontend-build
WORKDIR /app

# Copy package files first for better caching
COPY src/main/frontend/package*.json ./
RUN npm install

# Copy the rest of the frontend files and build the application
COPY src/main/frontend/ ./
COPY src/main/resources ./
RUN ls
RUN npm run build

# Step 2: Build the Spring Boot application
FROM maven:3.9.9-eclipse-temurin-23 AS spring-build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Step 3: Create the final image
FROM eclipse-temurin:23-alpine
WORKDIR /app

# Copy the built JAR file from the Spring Boot stage
COPY --from=spring-build /app/target/*.jar app.jar

# Copy the frontend build output directly to the Spring Boot static resources
COPY --from=frontend-build /app/static/css/main.css /app/src/main/resources/static/css/main.css

# Expose the port the app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
