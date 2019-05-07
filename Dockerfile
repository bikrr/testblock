FROM openjdk:7
VOLUME /tmp/
RUN ls
WORKDIR /tmp
RUN ls
RUN java -jar /tmp/testblock-client-0.0.1-SNAPSHOT.war

