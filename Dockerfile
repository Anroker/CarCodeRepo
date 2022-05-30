FROM openjdk:17-alpine

COPY target/CarCode.jar CarCode.jar

ENTRYPOINT ["java","-jar","/CarCode.jar"]
