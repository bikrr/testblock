FROM openjdk:8
RUN sudo apt-get update && sudo apt-get install postgresql postgresql-contrib
RUN sudo -u postgres createdb testblock
VOLUME /tmp/
WORKDIR /tmp
COPY /target/testblock-client-0.0.1-SNAPSHOT.war /tmp/
EXPOSE 8172
CMD java -jar /tmp/testblock-client-0.0.1-SNAPSHOT.war

