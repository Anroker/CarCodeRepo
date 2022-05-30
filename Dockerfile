FROM openjdk:17-alpine

COPY target/CarCode.jar CarCode.jar

JDBC=${ secrets.JDBCDB }
username=${ secrets.USER }
password=${ secrets.PASSWORD }

ENTRYPOINT["java","-jar","/CarCode.jar"]
