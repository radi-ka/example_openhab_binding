#!/usr/bin/env bash

sudo rm -rf addons/*

sudo cp ~/.ivy2/local/org.openmole.library/org-scala-lang-scala-library_2.13/2.13.0/bundles/org-scala-lang-scala-library_2.13.jar addons/
sudo cp target/scala-2.13/*.jar addons/

mkdir ${PWD}/addons

sudo docker run \
  --rm \
  --name openhab \
  --net=host \
  --env TZ=Europe/Berlin \
  -v ${PWD}/addons:/openhab/addons \
  openhab/openhab
