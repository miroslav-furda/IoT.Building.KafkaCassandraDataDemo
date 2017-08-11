package com.codexa.demo.ckc;

import com.codexa.demo.ckc.datagenerator.coap.CoapDataSender;
import com.codexa.demo.ckc.tocassandra.CassandraWriter;
import com.codexa.demo.ckc.tokafka.KafkaWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class CmdRunnerImpl implements CmdRunner {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private CoapDataSender coapDataSender;

    @Autowired
    private CassandraWriter cassandraWriter;

    @Autowired
    private KafkaWriter kafkaWriter;



    @Override
    public void writeGeneratedCoapData(Integer messageCount) {

        int availableCpus = Runtime.getRuntime().availableProcessors();
        log.info(String.format("Generate coap messages is going to use %d cpus/cores.", availableCpus));

        for (int i = 0; i < availableCpus; i++) {

            coapDataSender.sendSensorMessage(messageCount);
        }
        log.info("generating is over");
    }

    @Override
    public void writeToKafka() {
        System.out.println("write to kafka");
        kafkaWriter.send();
        //kafkaWriter.receive();
    }

    @Override
    public void writeToCassandra() {
        System.out.println("write to cassandra");
        cassandraWriter.write();
    }
}
