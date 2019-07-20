#!/usr/bin/env bash

sudo rm -rf addons/*

sudo cp target/scala-2.13/*.jar addons/
sudo cp bundles/scala-library/target/scala-2.13/*.jar addons/

mkdir ${PWD}/addons

sudo docker run \
  --rm \
  --name openhab \
  --net=host \
  --env TZ=Europe/Berlin \
  -v ${PWD}/addons:/openhab/addons \
  openhab/openhab
