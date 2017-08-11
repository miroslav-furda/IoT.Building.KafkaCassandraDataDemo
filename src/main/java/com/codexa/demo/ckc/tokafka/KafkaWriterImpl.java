package com.codexa.demo.ckc.tokafka;

import com.codexa.demo.ckc.tocassandra.SensorDataEntity;
import com.codexa.demo.ckc.util.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class KafkaWriterImpl implements KafkaWriter {

    @Value("${topic.boot}")
    private String topic;

    @Autowired
    private KafkaSender sender;


//    @Autowired
//    private KafkaReceiver receiver;

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

    @Override
    public void send() {
        for (int i = 0; i < 5; i++) {
            int seed = new Random().nextInt(1000);


            // send message created by generated class

            sender.send(topic,
                    Data.getAvroSensorMessage(
                            String.format("type-%d", seed),
                            String.format("value-%d", seed),
                            String.format("deviceId-%d", seed)

                    )
            );
            System.out.println("sended");
        }
    }
}