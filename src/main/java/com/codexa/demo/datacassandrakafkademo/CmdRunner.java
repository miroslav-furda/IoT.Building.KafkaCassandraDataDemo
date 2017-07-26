package com.codexa.demo.datacassandrakafkademo;

/**
 * Created by peter on 26.7.2017.
 */
public interface CmdRunner {

    void generateCoapData();
    void writeToKafka();
    void writeToCassandra();

}
