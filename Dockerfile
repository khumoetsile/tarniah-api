FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN curl -L https://services.gradle.org/distributions/gradle-6.5.1-bin.zip -o gradle-6.5.1-bin.zip
RUN unzip gradle-6.5.1-bin.zip
ENV GRADLE_HOME=/app/gradle-6.5.1
ENV PATH=$PATH:$GRADLE_HOME/bin
RUN gradle --version
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /build/libs/demo/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]