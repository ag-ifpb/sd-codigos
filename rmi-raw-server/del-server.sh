#!/bin/bash

#stopping
docker stop rmiserver
docker rm rmiserver

#remove
docker rmi java-rmi-server:latest
