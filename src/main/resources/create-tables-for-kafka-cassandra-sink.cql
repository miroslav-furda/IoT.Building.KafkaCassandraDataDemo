--
-- run for Cassandra to create structure for kafka - cassandra connector sink test
--

CREATE KEYSPACE IF NOT EXISTS demo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE demo;

CREATE TABLE IF NOT EXISTS demo.event_store(
    app_id text,
    event_type text,
    subscription_type text,
    event_ts timestamp,
    PRIMARY KEY((app_id, event_type), event_ts)
);

CREATE TABLE IF NOT EXISTS demo.event_store_sink(
    app_id text,
    event_type text,
    subscription_type text,
    event_ts timestamp,
    PRIMARY KEY((app_id, event_type), event_ts)
);

INSERT INTO demo.event_store (app_id,subscription_type,event_type,event_ts) VALUES ('website','annual','purchase',1457713158000);
INSERT INTO demo.event_store (app_id,subscription_type,event_type,event_ts) VALUES ('iphone','monthly','others',1457713159000);
INSERT INTO demo.event_store (app_id,subscription_type,event_type,event_ts) VALUES ('android','trial','purchase',1457713160000);
INSERT INTO demo.event_store (app_id,subscription_type,event_type,event_ts) VALUES ('website','monthly','renewal',1457713161000);
INSERT INTO demo.event_store (app_id,subscription_type,event_type,event_ts) VALUES ('website','monthly','others',1457713162000);