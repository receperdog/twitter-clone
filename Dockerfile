# Use the official OpenJDK image from the Docker Hub
FROM openjdk:17-jdk-slim

# Set the author label
LABEL authors="receptayyiperdogan"

# Create a volume to hold the application data
VOLUME /tmp

# Copy the application JAR file to the container
COPY auth-service/target/auth-service.jar auth-service.jar

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/auth-service.jar"]
