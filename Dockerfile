FROM maven:3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN cd /home/app && mvn test -B