FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Set the working directory to /app
WORKDIR /app

# Copy the Gradle Wrapper script and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy the rest of the application
COPY . .

# Make the Gradle Wrapper script executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /app/build/libs/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
