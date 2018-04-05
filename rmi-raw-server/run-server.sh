#!/bin/bash

#mvn
mvn clean

#construir o container
docker build -t java-rmi-server .

#java-rmi-server-running é o nome do container a ser ligado ao client
docker run -it --rm --name rmiserver java-rmi-server