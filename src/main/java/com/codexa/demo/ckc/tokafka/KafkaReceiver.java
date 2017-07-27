package com.codexa.demo.ckc.tokafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by peter on 26.7.2017.
 */
@Component
public class KafkaReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${topic.boot}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        System.out.println(String.format("received data= %s", consumerRecord.toString()));
        latch.countDown();
    }
}
