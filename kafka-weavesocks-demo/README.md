# weavesocks-kafka-up9-demo

This repository provides all necessaries files for deploy weavesocks with *Kafka* on a k8s cluster. Besides that, it include a quick tutorial to use up9.app to monitoring those resources created.


### Apply
First of all the command `kubectl create ns sock-shop` is recommended, we want to create all resources in this namespace.

If you already have an kubernetes cluster and LoadBalancer is an available option, you probably wont need to change a thing. Just run  `kubectl apply -f . -n sock-shop` on this folder, and all resources will be created, it'll probably take a minute or two to all services be accessble.

If u are running in minikube consider change the type of front-end service to NodePort.


### Access

If everything is running we can start navigate through the app. 

To get the Public IP of our front-end, you need to execute: `kubectl get svc -n sock-shop front-end` And get the IP from "External IP" column.

