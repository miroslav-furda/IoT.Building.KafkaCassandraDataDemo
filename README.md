# Kafka Cassandra data demo

Application that tests performance of architecture for storing sensor data.

## Main components

- **Coap message generator** : for testing purposes we have coap message generator
- **Kafka** : Sensor data are written to Kafka.
- **Cassandra** : Kafka writes data to Cassandra.


## How to run tests.


## Cassandra info

- Keyspace have to exist before first app run.
- Application uses sensor_data_test_3

```shell
CREATE KEYSPACE sensor_data_test_3 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}  AND durable_writes = true;
```


Few usefull commands

```shell
$ describe cluster
$ show keyspaces
$ show keyspace <name>
```