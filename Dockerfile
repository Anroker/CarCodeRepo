FROM openjdk:17-alpine

COPY target/CarCode.jar CarCode.jar

ENV JDBCDB=$JDBCDB
ENV USER=$USER
ENV PASSWORD=$PASSWORD

ENTRYPOINT ["java","-jar","/CarCode.jar"]
