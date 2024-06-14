# Build stage
FROM maven:3.9.7-eclipse-temurin-22 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Package stage
FROM openjdk:22-jdk-slim
COPY --from=build /home/app/target/receptiPUJ-0.0.1-SNAPSHOT.jar /app/receptiPUJ.jar
RUN mkdir /app/uploads
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/receptiPUJ.jar"]
