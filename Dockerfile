FROM openjdk:17-alpine

ARG JDBCDB
ARG USER
ARG PASSWORD

RUN echo $JDBCDB $USER

ENV DBAddress ${JDBCDB}
ENV USERDB ${USER}
ENV PASSWORDDB ${PASSWORD}

RUN --mount=type=secret,id=DBAddress \
  --mount=type=secret,id=USERDB \
  --mount=type=secret,id=PASSWORDDB \
   export DBAddress=$(cat /run/secrets/DBAddress) && \
   export USERDB=$(cat /run/secrets/USERDB) && \
   export PASSWORDDB=$(cat /run/secrets/PASSWORDDB) && \
   yarn gen

COPY target/CarCode.jar CarCode.jar



ENTRYPOINT ["java","-jar","/CarCode.jar"]
