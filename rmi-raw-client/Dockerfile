FROM maven:3.3.9-jdk-8

#add opt
ADD . /opt

#set work dir
WORKDIR /opt

#mvn package
RUN mvn package -DskipTests=true

#run service
CMD sh ./cmd.run