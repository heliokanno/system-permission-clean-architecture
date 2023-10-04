FROM openjdk:17-jdk-slim-buster
RUN mkdir /app

COPY /application/build/libs/system-permission-application-*.jar /app/system-permission-api.jar

WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app/system-permission-api.jar"]
