FROM openjdk:17-alpine

COPY target/CarCode.jar CarCode.jar

ENV JDBC=${ JDBCDB }
ENV username=${ USER }
ENV password=${ PASSWORD }

ENTRYPOINT["java","-jar","/CarCode.jar"]
