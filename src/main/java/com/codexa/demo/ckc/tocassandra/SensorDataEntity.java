package com.codexa.demo.ckc.tocassandra;


import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by peter on 26.7.2017.
 */

@Table("sensor_data")
public class SensorDataEntity implements Comparable, Serializable {

    private static final long serialVersionUID = 308933809830675395L;

    @PrimaryKey
    private UUID id;

    //@PrimaryKey
    @Column("device_id")
    private String deviceId;

    @Column("timestamp")
    private String timestamp;

    @Column("type")
    private String type;

    @Column("value")
    private String value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SensorDataEntity) {
            return this.id.compareTo(((SensorDataEntity)o).getId());
        } else {
            return 0;
        }
    }
}