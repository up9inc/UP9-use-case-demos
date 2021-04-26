# weavesocks-kafka-up9-demo

This repository provides all necessaries files for deploy weavesocks with *Kafka* on a k8s cluster. Besides that, it include a quick tutorial to use up9.app to monitoring those resources created.


### Apply

You'll need a running kubernetes cluster.

Clone https://github.com/up9inc/UP9-use-case-demos/ and go to kafka-weavesocks-demo folder/kubernetes-resources folder;
Now we need to create those resources, starts with the namespace:
```bash
> kubectl apply -f namespace.yaml
> kubectl apply -f . -n sock-shop
```

The kafka pod will be restarted for about 2-5 times before be ready, so don't worry about it.
Test the application, port-forward the front-end to access the weavesocks app.

```bash
> kubectl port-forward $(kubectl get pod -l name=front-end | tail -1 | cut -d ' ' -f 1) 8888:8079
```

Is time now to install up9.

After installed, it'll wait for some traffic be produced before shows the services on up9. To do that:
```bash
> kubectl apply -R -f job/.
```
The function of theses jobs is generate traffic, to the whole application, and to the front-end.

And it's done.
