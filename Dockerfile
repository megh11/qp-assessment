# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file
COPY pom.xml .

# Download the dependencies (in a separate layer to leverage caching)
RUN mvn dependency:go-offline -B

# Copy the source code into the container
COPY src /app/src

# Build the application
RUN mvn clean package -DskipTests

# Second stage: create the final image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/grocery-booking-api-0.0.1-SNAPSHOT.jar /app/grocery-booking-api.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/grocery-booking-api.jar"]
