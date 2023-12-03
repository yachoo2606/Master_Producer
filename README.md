# BUILD

```shell
docker build Producer -t producer --no-cache
```

# RUN

replace N with index of producer you want to run

```shell
docker run --network=applications_masterNetwork -e PEER_1_URL=http://172.20.0.2:9001/eureka/ -e PRODUCER_ID=N producer
```