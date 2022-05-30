FROM openjdk:17-alpine

ARG JDBCDB
ARG USER
ARG PASSWORD

RUN echo $JDBCDB $USER

ENV DBAddress ${JDBCDB}
ENV USERDB ${USER}
ENV PASSWORDDB ${PASSWORD}

COPY target/CarCode.jar CarCode.jar



ENTRYPOINT ["java","-jar","/CarCode.jar"]
