package com.codexa.demo.ckc.tocassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by peter on 26.7.2017.
 */

@Table("sensor_data")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
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


    @Override
    public int compareTo(Object o) {
        if (o instanceof SensorDataEntity) {
            return this.id.compareTo(((SensorDataEntity)o).getId());
        } else {
            return 0;
        }
    }
}