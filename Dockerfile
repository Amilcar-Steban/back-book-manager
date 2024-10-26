# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY library/target/library-0.0.1-SNAPSHOT.jar /app/library.jar

# Define environment variables
ENV DATABASE_URL=jdbc:mysql://database:3306/library
ENV SERVER_PORT=8081
ENV DATABASE_USER=amil
ENV DATABASE_PASSWORD=Amil3675

# Make port 8081 available to the world outside this container
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "library.jar"]