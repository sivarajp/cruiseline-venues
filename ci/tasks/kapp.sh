#!/bin/sh
set -e
mkdir -p ~/.kube
set +x
echo "------- KUBECONFIG ---------------------"
echo "$KUBECONFIG" 
echo "$KUBECONFIG" > ~/.kube/config
set -x
kapp deploy -a venues -f venues/k8s/deployment.yaml