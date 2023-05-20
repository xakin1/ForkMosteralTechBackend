FROM openjdk:17-jdk-slim

EXPOSE 8080

RUN mkdir -p /app/server
WORKDIR /app/server

COPY . /app/server

RUN chmod +x gradlew
RUN ./gradlew build

CMD ./gradlew bootRun
