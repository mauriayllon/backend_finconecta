# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Add the application's JAR file
COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar

# Set environment variables (this is generally not recommended for sensitive data)
ENV SPRING_DATA_MONGODB_DATABASE=demo
ENV SPRING_DATA_MONGODB_URI=mongodb://localhost:27017/demo
ENV SPRING_R2DBC_URL=r2dbc:postgresql://localhost:5432/demo
ENV SPRING_R2DBC_USERNAME=mauriayllon
ENV SPRING_R2DBC_PASSWORD=""

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","/app/backend.jar"]
