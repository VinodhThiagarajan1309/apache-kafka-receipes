# apache-kafka-receipes

### Pre-Requisites

- Install Docker
- Host Port mapping won't work with this image, hence kill any other processes that might block the below ports
###To Start KAFKA and ZooKeeper:

`docker run --rm -it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev`

The above must be left running for the reminder of the session. Below commands must be executed in a separate terminal 
window.

###To BASH into the container

`docker run --rm -it --net=host landoop/fast-data-dev bash`

##Below commands  must be RUN from the BASH

###To Create Topic
`kafka-topics --zookeeper 127.0.0.1:2181 --create --topic input-messages --partitions 3 --replication-factor 1`

###To Push Messages into Topic
`kafka-console-producer --broker-list 127.0.0.1:9092 --topic input-message`
 
