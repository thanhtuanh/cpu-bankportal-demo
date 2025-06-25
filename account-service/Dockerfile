
# Base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy dependencies and build
COPY target/account-service-0.0.1-SNAPSHOT.jar app.jar

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
