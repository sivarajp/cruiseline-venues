kubectl --kubeconfig=build-output/kube-config get pods
kubectl --kubeconfig=build-output/kube-config create -f build-output/deplyment.yaml