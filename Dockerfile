# Use official modern Java image
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy jar file
COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java","-jar","target/UserManagement-0.0.1-SNAPSHOT.jar"]
