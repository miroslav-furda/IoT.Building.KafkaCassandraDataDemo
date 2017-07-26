package com.codexa.demo.ckc.tocassandra;

/**
 * Created by peter on 26.7.2017.
 */
public interface CassandraWriter {
    void write();
    void write(SensorDataEntity sensorDataEntity);
}
