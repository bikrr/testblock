FROM openjdk:8
VOLUME /tmp/
RUN ls
WORKDIR /tmp
COPY /target/testblock-client-0.0.1-SNAPSHOT.war /tmp/
RUN ls
RUN java -jar /tmp/testblock-client-0.0.1-SNAPSHOT.war

