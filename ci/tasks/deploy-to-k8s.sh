#!/bin/sh
set -e
kubectl get pods
kubectl delete -f venues/deployment.yaml --ignore-not-found=true
kubectl create -f venues/deployment.yaml