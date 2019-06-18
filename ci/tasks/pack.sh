#!/bin/sh
set -e
cd venue
pack build venue -p .
docker tag venue gcr.io/fe-mwright/cruiseline/venue:latest
docker push gcr.io/fe-mwright/cruiseline/venue:latest
