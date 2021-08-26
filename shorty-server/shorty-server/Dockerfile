# Build stage
FROM maven:3.8.2-jdk-11 as build-stage
COPY src /usr/app/src
COPY pom.xml /usr/app
RUN mvn -f /usr/app/pom.xml clean package

# Serve stage
FROM openjdk:11-jre-slim
COPY --from=build-stage /usr/app/target/shorty-server-0.0.1-SNAPSHOT.jar /usr/app/target/shorty-server.jar
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x wait-for-it.sh

CMD ["./wait-for-it.sh" , "shorty_db:3306" , "--strict" , "--timeout=300" , "--" , "java", "-jar", "/usr/app/target/shorty-server.jar"]

EXPOSE 8089