FROM openjdk:8
VOLUME /tmp/
WORKDIR /tmp
COPY /target/testblock-client-0.0.1-SNAPSHOT.war /tmp/
EXPOSE 8172
CMD java -jar /tmp/testblock-client-0.0.1-SNAPSHOT.war

