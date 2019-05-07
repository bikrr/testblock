FROM openjdk:7
WORKDIR /tmp
RUN java -jar testblock-client-0.0.1-SNAPSHOT.war

