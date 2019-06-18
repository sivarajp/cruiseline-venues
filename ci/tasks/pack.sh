#!/bin/sh
set -e
source entrypoint.sh
start_docker
cd venue
pack set-default-builder cloudfoundry/cnb:bionic
pack build venue -p .
docker tag venue gcr.io/fe-mwright/cruiseline/venue:latest
docker push gcr.io/fe-mwright/cruiseline/venue:latest
