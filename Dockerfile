FROM maven:3.8.4-openjdk-17-slim AS build

COPY pom.xml ./
COPY .mvn .mvn

COPY src src

RUN mvn clean install

FROM openjdk:17-jdk-slim

WORKDIR demo

COPY --from=build target/*.jar demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]
