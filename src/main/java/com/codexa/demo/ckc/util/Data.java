package com.codexa.demo.ckc.util;

import com.codexa.demo.ckc.tocassandra.SensorDataEntity;
import com.datastax.driver.core.utils.UUIDs;

/**
 * Created by peter on 28.7.2017.
 */
public class Data {

    public static SensorDataEntity getSensorMessage(String type, String value, String deviceId) {

        SensorDataEntity sensorDataEntity = new SensorDataEntity();
        sensorDataEntity.setId(UUIDs.timeBased());
        sensorDataEntity.setTimestamp(String.format("%s", System.currentTimeMillis()));
        sensorDataEntity.setType(type);
        sensorDataEntity.setValue(value);
        sensorDataEntity.setDeviceId(deviceId);
        return sensorDataEntity;
    }
}
