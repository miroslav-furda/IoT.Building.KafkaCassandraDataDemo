package com.codexa.demo.ckc;

/**
 * Created by peter on 26.7.2017.
 */
public interface CmdRunner {

    void writeGeneratedCoapData(Integer messageCount);
    void writeToKafka();
    void writeToCassandra();

}
