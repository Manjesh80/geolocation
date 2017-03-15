#!/usr/bin/env bash

version=$1

echo "Releasing version ==> " + $version

mvn clean package -DskipTests
docker stop $(docker ps -a | grep "manjesh80/geolocation-consul-lb" | awk '{print $1}')
docker rm $(docker ps -a | grep "manjesh80/geolocation-consul-lb" | awk '{print $1}')
docker rmi -f $(docker images | grep "manjesh80/geolocation-consul-lb" | awk '{print $3}' )
docker build -t manjesh80/geolocation-consul-lb:latest -t manjesh80/geolocation-consul-lb:$version .
