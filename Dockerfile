FROM openjdk:7
WORKDIR /tmp
RUN ls
RUN java -jar /tmp/testblock-client-0.0.1-SNAPSHOT.war

