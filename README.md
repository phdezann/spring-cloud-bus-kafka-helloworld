
Hello World Spring Boot micro-service communicating with a Kafka cluster

```
$ docker-compose down -t 0
$ docker-compose up -d --build
```

Let's test if no messages are lost in the event of a broker fatal failure.

```
# post messages into our 3 partitions
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
sleep 1
# kill one broker
docker rm helloworld-kafka-2 -f
sleep 1
# post messages into our 3 partitions, one will get a 500 error code
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
curl -X GET http://172.170.0.50/hello
```
