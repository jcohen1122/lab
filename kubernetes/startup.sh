minikube start # start minikube cluster

if [ "$(kubectl config current-context)" != "minikube" ]; then
  kubectl config use-context minikube # switch context if needed
fi

kubectl get pods -A -o wide # showing pods running using kubectl

# Create and monitor deployment
kubectl create deployment test --image=nginx --replicas=10 --dry-run=client -o yaml > deploy.yaml
kubectl apply -f deploy.yaml
watch -n 1 "kubectl get pods -o wide"
kubectl get deployments.apps