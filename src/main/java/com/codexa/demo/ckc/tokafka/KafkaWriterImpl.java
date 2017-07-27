package com.codexa.demo.ckc.tokafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class KafkaWriterImpl implements KafkaWriter {

    private static String BOOT_TOPIC = "boot.t";

    @Autowired
    private KafkaSender sender;

//    @Autowired
//    private KafkaReceiver receiver;

    @Override
    public void send() {
        sender.send(BOOT_TOPIC, "Hello Boot! 2");
        System.out.println("sended");
    }

//    @Override
//    public void receive() {
//        System.out.println(receiver.getLatch().getCount());
//
//        try {
//            receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
