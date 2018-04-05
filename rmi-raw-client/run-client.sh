#!/bin/bash

#construir o container
docker build -t java-rmi-client .

#java-rmi-server-running é o nome do container a ser ligado ao client
docker run -it --rm --name rmiclient --link=rmiserver java-rmi-client