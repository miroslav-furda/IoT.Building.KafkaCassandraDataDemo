package com.codexa.demo.ckc.config;

import com.codexa.demo.ckc.datagenerator.CoapDataGenerator;
import com.codexa.demo.ckc.datagenerator.CoapDataGeneratorImpl;
import com.codexa.demo.ckc.tocassandra.CassandraWriter;
import com.codexa.demo.ckc.tocassandra.CassandraWriterImpl;
import com.codexa.demo.ckc.tokafka.KafkaWriter;
import com.codexa.demo.ckc.tokafka.KafkaWriterImpl;
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
