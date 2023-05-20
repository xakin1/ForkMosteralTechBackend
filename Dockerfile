FROM openjdk:11

RUN mkdir -p /app/server
WORKDIR /app/server

COPY . /app/server

RUN chmod +x gradlew
RUN ./gradlew build

CMD ./gradlew bootRun
