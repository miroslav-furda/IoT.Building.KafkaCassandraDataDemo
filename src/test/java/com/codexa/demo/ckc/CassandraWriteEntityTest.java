package com.codexa.demo.ckc;


import com.codexa.demo.ckc.tocassandra.CassandraWriterRepository;
import com.codexa.demo.ckc.tocassandra.SensorDataEntity;

import com.codexa.demo.ckc.util.Data;
import com.datastax.driver.core.utils.UUIDs;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by peter on 26.7.2017.
 *
 * This test use real cassandra not in memory one. The reason is to see if it works !
 * When building artifact use -DskipTests , use tests just for development.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CassandraWriteEntityTest {

    @Autowired
    private CassandraWriterRepository cassandraWriterRepository;

    @Test
    public void cassandraWriteEntityTest() {

        cassandraWriterRepository.deleteAll();

        Assert.assertEquals(0, cassandraWriterRepository.count());

        cassandraWriterRepository.save(Data.getSensorMessage("type1", "value1", "deviceId1"));
        cassandraWriterRepository.save(Data.getSensorMessage("type2", "value2", "deviceId2"));

        Assert.assertEquals(2, cassandraWriterRepository.count());

        Iterator<SensorDataEntity> sensorData = cassandraWriterRepository.findAll().iterator();
        List<SensorDataEntity>  list = Lists.newArrayList(sensorData);
        Collections.sort(list);


        Assert.assertEquals("type1", list.get(0).getType());
        Assert.assertEquals("type2", list.get(1).getType());

        Assert.assertEquals("value1", list.get(0).getValue());
        Assert.assertEquals("value2", list.get(1).getValue());

        Assert.assertEquals("deviceId1", list.get(0).getDeviceId());
        Assert.assertEquals("deviceId2", list.get(1).getDeviceId());


        // to see data in db comment this 2 lines of code
//        cassandraWriterRepository.deleteAll();
//        Assert.assertEquals(0, cassandraWriterRepository.count());
    }
}