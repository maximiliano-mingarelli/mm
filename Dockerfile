FROM  amazoncorretto:11-alpine-jdk
MAINTAINER  MM
COPY target/mm-0.0.1-SNAPSHOT.jar mm-app.jar

ENTRYPOINT  ["java","-jar","/mm-app.jar"]
