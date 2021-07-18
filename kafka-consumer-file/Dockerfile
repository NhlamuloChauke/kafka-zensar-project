# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Create user and group
RUN addgroup -S kafkaconsumer && adduser -S kafkaconsumer -G kafkaconsumer

USER kafkaconsumer:kafkaconsumer

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]