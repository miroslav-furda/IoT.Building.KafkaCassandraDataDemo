# Kafka Cassandra data demo

Application that tests performance of architecture for storing sensor data.

## Main components

- **Coap message generator** : for testing purposes we have coap message generator
- **Kafka** : Sensor data are written to Kafka.
- **Cassandra** : Kafka writes data to Cassandra.

## Versions used
- Cassandra 3.11.0 
- Kafka TODO
- ...

## How to run tests.

### Prerequisities
```shell
docker run --name darwin-cassandra -td --restart always -p 7000:7000 -p 7001:7001 -p 9042:9042 -p 9160:9160 -p 7199:7199 cassandra:latest
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