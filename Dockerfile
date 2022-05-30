FROM openjdk:17-alpine

ENV JDBCDB=$INPUT_JDBCDB
ENV USER=$INPUT_USER
ENV PASSWORD=$INPUT_PASSWORD

COPY target/CarCode.jar CarCode.jar



ENTRYPOINT ["java","-jar","/CarCode.jar"]
