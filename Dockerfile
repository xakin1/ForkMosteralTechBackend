FROM openjdk:11

RUN mkdir -p /app/server
WORKDIR /app/server

COPY . /app/server

RUN chmod +x gradlew
RUN ./gradlew build

CMD ./gradlew --no-daemon bootRun --args='--spring.profiles.active=prod'

