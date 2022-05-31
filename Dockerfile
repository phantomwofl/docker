FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/spring-netology-0.0.1-SNAPSHOT.jar spring-boot-docker.jar
