#!/bin/sh
set -e
cd venue
./mvnw package
cp target/venue-0.0.1-SNAPSHOT.jar ../build-output/
cp manifest.yml ../build-output/