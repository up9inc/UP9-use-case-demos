[![Build Status](https://travis-ci.org/microservices-demo/shipping.svg?branch=master)](https://travis-ci.org/microservices-demo/shipping) [![Coverage Status](https://coveralls.io/repos/github/microservices-demo/shipping/badge.svg?branch=master)](https://coveralls.io/github/microservices-demo/shipping?branch=master)
[![](https://images.microbadger.com/badges/image/weaveworksdemos/shipping.svg)](http://microbadger.com/images/weaveworksdemos/shipping "Get your own image badge on microbadger.com")

# shipping
A microservices-demo service that provides shipping capabilities. The difference for the original shipping is that we use Kafka and had a small check on method POST, variable ID, if is an uuid4 object.

# Build

## Java
Go to root foldr of shipping-demo and run

`mvn -DskipTests package`
`docker run -v $(pwd):/app -it -w /app maven:3.6.3-openjdk-8-slim mvn -DskipTests package`

## Build (docker)

Copy the .jar in target/ folder to docker/shipping/, and inside docker/shipping/, run:

`docker build -t shipping-kafka-check-id .`

# Test

`./test/test.sh < python testing file >`. For example: `./test/test.sh unit.py`

# Run

`mvn spring-boot:run`

# Check

`curl http://localhost:8080/health`

# Use

`curl http://localhost:8080`

# Push

`GROUP=weaveworksdemos COMMIT=test ./scripts/push.sh`
