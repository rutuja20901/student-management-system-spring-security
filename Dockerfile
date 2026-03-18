# Use official modern Java image
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy jar file
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]