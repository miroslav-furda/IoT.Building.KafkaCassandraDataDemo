package com.codexa.demo.datacassandrakafkademo.config;

import com.codexa.demo.datacassandrakafkademo.datagenerator.CoapDataGenerator;
import com.codexa.demo.datacassandrakafkademo.datagenerator.CoapDataGeneratorImpl;
import com.codexa.demo.datacassandrakafkademo.tocassandra.CassandraWriter;
import com.codexa.demo.datacassandrakafkademo.tocassandra.CassandraWriterImpl;
import com.codexa.demo.datacassandrakafkademo.tokafka.KafkaWriter;
import com.codexa.demo.datacassandrakafkademo.tokafka.KafkaWriterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by peter on 26.7.2017.
 */
@Configuration
public class Beans {

    @Bean
    public CoapDataGenerator coapDataGenerator() {
        return new CoapDataGeneratorImpl();
    }

    @Bean
    public CassandraWriter cassandraWriter() {
        return new CassandraWriterImpl();
    }

    @Bean
    public KafkaWriter kafkaWriterImpl() {
        return new KafkaWriterImpl();
    }

}
