# # Use a base image with JDK and Maven to build the application
# FROM maven:3.8.4-openjdk-11 AS build
# WORKDIR /app
# COPY pom.xml .
# COPY src ./src
# RUN mvn clean package

# # Use a base image with JRE to run the application
# FROM openjdk:11-jre-slim
# # WORKDIR /app
# # COPY --from=build /app/target/*.jar app.jar
# COPY target/E-Commerce-0.0.1-SNAPSHOT.jar E-Commerce-0.0.1-SNAPSHOT.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "E-Commerce-0.0.1-SNAPSHOT.jar"]
# WORKDIR /app

FROM openjdk:17-jdk-slim AS build

Add target/E-Commerce-0.0.1-SNAPSHOT.jar E-Commerce-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","E-Commerce-0.0.1-SNAPSHOT.jar"]