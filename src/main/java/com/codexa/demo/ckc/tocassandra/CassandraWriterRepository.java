package com.codexa.demo.ckc.tocassandra;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by peter on 26.7.2017.
 */
public interface CassandraWriterRepository extends CrudRepository<SensorDataEntity, String> {

    @Query("select * from sensor_data_test_3.sensor_data where deviceId=?0")
    SensorDataEntity findByDeviceId(String deviceId);
}
