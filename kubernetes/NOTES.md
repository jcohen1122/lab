# [🔗](https://kubernetes.io/docs/home/) Kubernetes Notes

## What is Kubernetes (K8s)?
Containerization allows multiple applications to run in a single environment (Docker). Results in less VM's you need to manage and upgrade.

Kubernetes is a system designed to solve the problem of many VM's and containers running. It is the operating system of the cloud.

**Kubernetes is a bunch of VM's who are able to communicate properly with each other and divide their workload (load balancing).**
Each VM is called a **worker node**. The load balancer is called the **control plane**. The control plane is given requests from a **YAML file**. Requests are routed to worker nodes based on level of traffic. More worker nodes are created if traffic increases, and worker nodes are taken away if they are not needed. If a container fails, kubernetes will recognize this and spin up a replacement.

**Flow:** 
1. Cluster is provisioned (Rancher/Docker Desktop/minikube).
2. Cluster contains control plane and worker nodes.
3. Nodes run pods, pods run containers.
4. YAML files define resources, submitted to control plane.
5. Control plane schedules pods, manages scaling and health.

## Definitions
**Control Plane:** The load balancer that is given requests via YAML files. Also manages overall cluster state, scheduling, and monitoring.

**YAML Files:** These define desired state (deployments, services, etc) and are submitted to the control plane via **kubectl**.

**Manifest:** A YAML (or JSON) file that declares the desired state of a Kubernetes resource (such as a Pod, Deployment, Service, etc).

**Worker Nodes:** Virtual Machines within the cluster. Run pods, which in turn run containers.

**[🔗](https://kubernetes.io/docs/concepts/workloads/pods/) Pods:** Usually runs a single container, but can run multiple if they need to share resources. Pods have **labels** which are used to organize, identify, and select them. Labels are key=value pairs.

**Scaling:** The control plane schedules pods onto nodes; nodes can be added/removed manually or automatically.

**Context:** A named set of parameters that defines how **kubectl** connects to a specific Kubernetes cluster. Includes the cluster, user, and namespace.

**Namespaces:** provides a mechanism for isolating groups of resources within a single cluster. The initial namespace is **default**.

## Installing Needed Packages
Install needed packages using brew
```bash
brew install kubectl # command-line tool for interacting with Kubernetes clusters
brew install minikube # tool for running a local Kubernetes cluster on your machine
brew install helm # package manager for Kubernetes that helps you manage Kubernetes applications
```

## Useful Commands
### [🔗](https://minikube.sigs.k8s.io/docs/start/) minikube
```bash
minikube start # start cluster
minikube stop # stop cluster
minikube delete # delete cluster
minikube status # show pods running
```

### [🔗](https://kubernetes.io/docs/tasks/tools/) kubectl
Informational Commands
```bash
kubectl explain [resource] # show documentation for a resource
kubectl describe -f [pod] # give information about a pod

kubectl get pods -A # show all pods running
kubectl get pods -o wide # show IP, node, etc
kubectl get deployments.apps # show deployments
 
kubectl config # list configurations
kubectl config current-context # minikube, docker-desktop, rancher-desktop, etc
kubectl config get-contexts # show available contexts
kubectl config use-context [context] # use an available context
```
Applicable Commands
```bash
kubectl run [name] # create and run a particular image in a pod
kubectl apply [file.yaml] # apply a configuration to a resource
kubectl edit pod [pod] # Edit the pod YAML file
kubectl delete pod [pod] # Delete a pod
kubectl exec [pod] -- [command] # Execute a command in the pod
```
```bash
kubectl create deployment NAME --image=image -- [COMMAND] [args...] [options] # create a deployment with the specified name
kubectl edit deployments.apps NAME # edit deployment
kubectl delete deployments.apps NAME # delete deployment
```

### [🔗](https://helm.sh/docs/intro/CheatSheet) helm
Package manager for Kubernetes
```bash
helm create [chart] # Creates a chart directory along with the common files and directories used in a chart.
helm package [chart] # Packages a chart into a versioned chart archive file.
helm lint [chart] # Run tests to examine a chart and identify possible issues:
helm show all [chart] # Inspect a chart and list its contents:
helm show values [chart] # Displays the contents of the values.yaml file
helm pull [chart] # Download/pull chart
helm dependency list [chart] # Display a list of a chart’s dependencies:
# more on document linked
```

## Creating and Running An Example Pod
```bash
kubectl run nginx --image=nginx --dry-run=client -o yaml > nginx.yaml # create example YAML definition and pipe to new .yaml
kubectl apply -f nginx.yaml # apply new .yaml
kubectl get pods # ensure pod is running
kubectl describe nginx # get pod information
```
Can edit and reapply pod
```bash
code nginx.yaml
### edit file ###
kubectl apply -f nginx.yaml
```
Can interact with the pod
```bash
kubectl exec -it nginx -- /bin/bash # enter interactive shell within container
apt update # download and update packages
apt install htop # install htop
htop # can view resources within pod
```

## Deployment Examples
Normally you don't just run one pod with k8.
```bash
kubectl create deployment test --image=nginx --replicas=3
kubectl get deployments.apps
kubectl edit deployments.apps test
kubectl delete deployments.apps test
```
Can do a dry run to get a test YAML much like with ```kubectl run```.
```bash
kubectl create deployment test --image=nginx --replicas=10 --dry-run=client -o yaml > deploy.yaml # Create example deployment YAML
kubectl apply -f deploy.yaml
kubectl get deployments.apps
kubectl get replicasets.apps # ReplicaSets create pods in the background
code deploy.yaml # can edit and update which image is used
kubectl apply -f deploy.yaml # reapply yaml
watch -n 1 "kubectl get pods" # watch actively running pods
```
You can also manage namespaces
```bash
kubectl get namespaces
kubectl create namespace test-namespace -o yaml --dry-run=client > namespace.yaml # Create example namespace YAML
```