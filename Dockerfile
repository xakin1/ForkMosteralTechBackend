FROM openjdk:11

RUN mkdir -p /app/server

WORKDIR /app/server

CMD chmod 777 gradlew && ./gradlew bootRun --args='--spring.profiles.active=prod'
