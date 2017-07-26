package com.codexa.demo.ckc.tocassandra;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class CassandraWriterImpl implements CassandraWriter {

    @Autowired
    private CassandraWriterRepository cassandraWriterRepository;

    @Override
    public void write() {
        cassandraWriterRepository.save(getSensorMessage("type3", "value3", "deviceId3"));
        cassandraWriterRepository.save(getSensorMessage("type4", "value4", "deviceId4"));
    }

    @Override
    public void write(SensorDataEntity sensorDataEntity) {
        if (null != sensorDataEntity) {
            cassandraWriterRepository.save(sensorDataEntity);
        } else {
            System.out.println("Trying to store null entity to cassandra.");
        }
    }

    private SensorDataEntity getSensorMessage(String type, String value, String deviceId) {
        SensorDataEntity sensorDataEntity = new SensorDataEntity();
        sensorDataEntity.setId(UUIDs.timeBased());
        sensorDataEntity.setTimestamp(System.currentTimeMillis() + "");
        sensorDataEntity.setType(type);
        sensorDataEntity.setValue(value);
        sensorDataEntity.setDeviceId(deviceId);
        return sensorDataEntity;
    }
}
