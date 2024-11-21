# the base image with JDK used to build and run your Java application
FROM eclipse-temurin:23-jdk

# labelling the docker file
LABEL MAINTAINER="remus"
LABEL description="This is vttp ssf day 12 docker image"
LABEL name="vttp-5a-day12l"

ARG APP_DIR=/app

# directory where your src will reside in
WORKDIR ${APP_DIR}

# Install Maven
# RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy the required files/directories into the image 
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY src src

# Package the application using the RUN directive
# This will download the dependencies defined in pom.xml
# Compile and package to JAR
# RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true
# RUN mvn package -Dmaven.test.skip=true
RUN chmod a+x ./mvnw && ./mvnw clean package -Dmaven.test.skip=true -e

RUN ls -l target/

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp5_sdf_day12l-0.0.1-SNAPSHOT.jar