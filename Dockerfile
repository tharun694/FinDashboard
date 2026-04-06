# Use the stable Eclipse Temurin image
FROM eclipse-temurin:17-jdk-focal

# Set working directory
WORKDIR /app

# Copy the jar file (keep this as we fixed before)
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]