FROM openjdk:17-alpine

ARG JDBCDB
ARG USER
ARG PASSWORD

ENV JDBCDB=$JDBCDB
ENV USER=$USER
ENV PASSWORD=$PASSWORD

COPY target/CarCode.jar CarCode.jar



ENTRYPOINT ["java","-jar","/CarCode.jar"]
