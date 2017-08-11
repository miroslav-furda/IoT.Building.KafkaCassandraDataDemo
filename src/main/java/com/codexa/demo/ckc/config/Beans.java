package com.codexa.demo.ckc.config;

import com.codexa.demo.ckc.datagenerator.coap.CoapDataSender;
import com.codexa.demo.ckc.datagenerator.CoapDataSenderImpl;
import com.codexa.demo.ckc.tocassandra.CassandraWriter;
import com.codexa.demo.ckc.tocassandra.CassandraWriterImpl;
import com.codexa.demo.ckc.tokafka.KafkaWriter;
import com.codexa.demo.ckc.tokafka.KafkaWriterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * Created by peter on 26.7.2017.
 */
@EnableAsync
//@EnableKafka
@Configuration
public class Beans {


    @Bean
    public CoapDataSender coapDataSender() {
        return new CoapDataSenderImpl();
    }

    @Bean
    public CassandraWriter cassandraWriter() {
        return new CassandraWriterImpl();
    }

    @Bean
    public KafkaWriter kafkaWriterImpl() {
        return new KafkaWriterImpl();
    }



    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();


        props.put("schema.registry.url", "http://192.168.1.137:8099");
        return props;
    }






    @Bean
    public Executor asyncExecutor() {

        int availableCores = Runtime.getRuntime().availableProcessors();

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(availableCores);
        executor.setMaxPoolSize(availableCores);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Coap sender-");
        executor.initialize();
        return executor;
    }
}