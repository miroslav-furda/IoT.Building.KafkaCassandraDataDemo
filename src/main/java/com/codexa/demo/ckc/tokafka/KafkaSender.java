package com.codexa.demo.ckc.tokafka;

import com.codexa.demo.ckc.tocassandra.SensorDataEntity;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by peter on 26.7.2017.
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, SensorDataEntity> kafkaTemplate;

    @Value("${topic.boot}")
    private String topic;

    public void send(String topic, SensorDataEntity data) {

        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("sending data= %s to topic= %s", data, topic));
            //kafkaTemplate.send(topic, data + " " + i);
            kafkaTemplate.send(topic, data);
        }
    }
}