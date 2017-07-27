package com.codexa.demo.ckc.tokafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by peter on 26.7.2017.
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String data) {

        for (int i = 0; i < 500; i++) {
            System.out.println(String.format("sending data= %s to topic= %s", data, topic));
            kafkaTemplate.send(topic, data + " " + i);
        }
    }
}