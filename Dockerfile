# Usa la imagen base con Java 17
FROM bellsoft/liberica-openjdk-alpine:17

# Copia el archivo JAR de la aplicación al contenedor
COPY target/backend-0.0.1-SNAPSHOT.jar /app/backend.jar

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/backend.jar"]

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080