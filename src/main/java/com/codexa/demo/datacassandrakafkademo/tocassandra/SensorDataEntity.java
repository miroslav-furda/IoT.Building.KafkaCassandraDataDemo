package com.codexa.demo.datacassandrakafkademo.tocassandra;

import lombok.Data;
import lombok.ToString;

/**
 * Created by peter on 26.7.2017.
 */
@Data
@ToString
public class SensorDataEntity {

    private String deviceId;
    private String timestamp; // TODO maybe default for cassandra
    private String type;
    private String value;

}
