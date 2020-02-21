# cruiseline-venues

This is a sample Spring boot app inspired by https://github.com/aniruthmp/microservices-springboot-docker

Pivotal Build Service is used to automatically create a docker image from git commit trigger.   Pivotal Build Service is deployed to a Kubernetes cluster that is spun up using "pks create cluster"

The entire process, the cluster, building and testing the app, clean up can be entirely ephemeral saving value cloud resources when no dev is in active progress.

Used for demo purposes

Update counter for demo: 7

![Pipeline Image](https://github.com/mwright-pivotal/cruiseline-venues/raw/master/ci/pipeline-image.png)
