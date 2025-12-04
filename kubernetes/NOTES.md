# Kubernetes Notes

## What is Kubernetes?
Containerization allows multiple applications to run in a single environment (Docker). Results in less VM's you need to manage and upgrade.

Kubernetes is a system designed to solve the problem of many VM's and containers running. It is the operating system of the cloud.

**Kubernetes is a bunch of VM's who are able to communicate properly with each other and divide their workload (load balancing).**
Each VM is called a **worker node**. The load balancer is called the **control plane**. The control plane is given requests from a **YAML file**. Requests are routed to worker nodes based on level of traffic. More worker nodes are created if traffic increases, and worker nodes are taken away if they are not needed. If a container fails, kubernetes will recognize this and spin up a replacement.

**Flow:** YAML file gives its request to the control plane, who routes that request to the appropriate worker node, who then routes the request to the correct container.

## Applying Kubernetes
Install needed packages using brew
```bash
brew install kubectl # command-line tool for interacting with Kubernetes clusters
brew install minikube # tool for running a local Kubernetes cluster on your machine
brew install helm # package manager for Kubernetes that helps you manage Kubernetes applications
```

### [minikube](https://minikube.sigs.k8s.io/docs/start/)
```bash
minikube start # start cluster
minikube stop # stop cluster
minikube status # show pods running
```

### [kubectl](https://kubernetes.io/docs/tasks/tools/)
```bash
kubectl get pods -A # Show all pods running
```

### [helm](https://helm.sh/docs/intro/install/)
```bash
```