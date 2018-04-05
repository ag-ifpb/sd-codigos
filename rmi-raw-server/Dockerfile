FROM maven:3.3.9-jdk-8

#add opt
ADD . /opt

#set work dir
WORKDIR /opt

#mvn package
RUN mvn clean package -DskipTests=true

#run service
CMD /usr/bin/java -cp target/rmi-raw-server.jar:lib/* ag.ifpb.rmi.raw.server.App