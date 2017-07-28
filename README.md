# Kafka Cassandra data demo

Application that tests performance of architecture for storing sensor data.

## Main components

- **Coap message generator** : for testing purposes we have coap message generator
- **Kafka** : Sensor data are written to Kafka.
- **Cassandra** : Kafka writes data to Cassandra.

## Versions used
- Cassandra 3.11.0 
- Kafka 0.10.1.0
- ...
- Kafka Cassandra Sink Connector
- Kafka Coap Source Connector

## How to run tests.

### Prerequisites

- **Cassandra**
```shell
$ docker run --name darwin-cassandra -td --restart always -p 7000:7000 -p 7001:7001 -p 9042:9042 -p 9160:9160 -p 7199:7199 cassandra:latest
```

 - **Kafka**
```shell
$ sudo docker run --name darwin-kafka --restart always -td  -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=`192.168.1.137` --env ADVERTISED_PORT=9092 spotify/kafka
```

- **Coap server**
```shell
$ sudo docker run --name darwin-coap-server --restart always -td -p 5683:5683/udp markushx/coap
```

### Check prerequisites if working

KAFKA on host
```shell
$ echo dump | nc localhost 2181 | grep brokers
```
You should see something like 
```shell
	/brokers/ids/0
```

CASSANDRA on host

```shell
$ nc -vz 192.168.1.137 9042 
```

CASSANDRA on guest
```shell
$ cqlsh
$ describe cluster
$ nodetool -h 192.168.1.137 -p 7199 info
$ nodetool -h 192.168.1.137 -p 7199 status
$ nodetool -h 192.168.1.137 -p 7199 ring
```

## Cassandra info

- Keyspace have to exist before first app run.
- Application uses keyspace sensor_data_test_3

```shell
CREATE KEYSPACE sensor_data_test_3 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}  AND durable_writes = true;
```


### Few useful commands

```shell
$ describe cluster
$ show keyspaces
$ show keyspace <name>
```



# Kafka

See the topics (on vm)
```shell
$ /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --list --zookeeper localhost:2181
```
See messages
```shell
$ /opt/kafka_2.11-0.10.1.0/bin/kafka-run-class.sh kafka.tools.SimpleConsumerShell --broker-list 192.168.1.137:9092 --topic boot.t --partition 0
```
