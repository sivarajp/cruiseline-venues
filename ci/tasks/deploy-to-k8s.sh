#!/bin/sh
set -e
kubectl --kubeconfig=build-output/kube-config get pods
kubectl --kubeconfig=build-output/kube-config delete -f build-output/deployment.yaml
kubectl --kubeconfig=build-output/kube-config create -f build-output/deployment.yaml