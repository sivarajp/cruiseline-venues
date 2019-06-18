#!/bin/sh
set -e
cruiseline-venue/mvnw package
cp cruiseline-venue/target/venue-0.0.1-SNAPSHOT.jar build-output/