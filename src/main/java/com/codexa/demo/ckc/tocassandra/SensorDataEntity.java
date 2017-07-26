package com.codexa.demo.ckc.tocassandra;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.UUID;

/**
 * Created by peter on 26.7.2017.
 */

@Table("sensor_data")
@ToString
@Data
public class SensorDataEntity implements Comparable {

    @PrimaryKey
    private UUID id;

    @Column("device_id")
    private String deviceId;

    @Column("timestamp")
    private String timestamp; // TODO maybe default for cassandra

    @Column("type")
    private String type;

    @Column("value")
    private String value;


    @Override
    public int compareTo(Object o) {
        if (o instanceof SensorDataEntity) {
            return this.id.compareTo(((SensorDataEntity)o).getId());
        } else {
            return 0;
        }
    }
}
