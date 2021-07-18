# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Create user and group
RUN addgroup -S kafkaproducer && adduser -S kafkaproducer -G kafkaproducer

USER kafkaproducer:kafkaproducer

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]