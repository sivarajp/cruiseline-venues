#!/bin/sh
set -e
venue/mvnw package
cp venue/target/venue-0.0.1-SNAPSHOT.jar build-output/