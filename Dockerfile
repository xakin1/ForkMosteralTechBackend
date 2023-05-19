FROM openjdk:11

RUN mkdir -p /app/server
WORKDIR /app/server

COPY . /app/server

RUN chmod +x gradlew
ENV GRADLE_OPTS="-Xmx2g"
RUN ./gradlew build

CMD ./gradlew bootRun
