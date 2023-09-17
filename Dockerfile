FROM gradle:8.3.0-jdk17-alpine as builder
WORKDIR /app
COPY . /app
RUN ./identity-service/gradlew bootJar

FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=builder /app/identity-service/build/libs/*.jar /app/application.jar
ENTRYPOINT ["java","-jar","application.jar"]