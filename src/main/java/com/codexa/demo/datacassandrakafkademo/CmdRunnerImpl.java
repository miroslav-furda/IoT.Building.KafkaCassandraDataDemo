package com.codexa.demo.datacassandrakafkademo;

import com.codexa.demo.datacassandrakafkademo.datagenerator.CoapDataGenerator;
import com.codexa.demo.datacassandrakafkademo.tocassandra.CassandraWriter;
import com.codexa.demo.datacassandrakafkademo.tokafka.KafkaWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class CmdRunnerImpl implements CmdRunner {


    @Autowired
    private CoapDataGenerator coapDataGenerator;

    @Autowired
    private CassandraWriter cassandraWriter;

    @Autowired
    private KafkaWriter kafkaWriter;



    @Override
    public void generateCoapData() {
        System.out.println("generate coap messages");
    }

    @Override
    public void writeToKafka() {
        System.out.println("write to kafka");
    }

    @Override
    public void writeToCassandra() {
        System.out.println("write to cassandra");
    }
}
