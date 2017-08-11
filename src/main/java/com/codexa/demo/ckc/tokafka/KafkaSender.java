package com.codexa.demo.ckc.tokafka;

import com.codexa.demo.ckc.notworking.SensorDataEntityAvro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by peter on 26.7.2017.
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, SensorDataEntityAvro> kafkaTemplate;

    @Value("${topic.boot}")
    private String topic;

    public void send(String topic, SensorDataEntityAvro data) {

        System.out.println(String.format("sending data= %s to topic= %s", data, topic));
        int keyInt = new Random().nextInt(10000);
        kafkaTemplate.send(topic,  keyInt + "", data);
    }

}