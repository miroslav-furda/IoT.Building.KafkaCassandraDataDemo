package com.codexa.demo.ckc.datagenerator.coap;


import org.eclipse.californium.core.coap.Message;

import java.net.UnknownHostException;

/**
 * Created by peter on 26.7.2017.
 */
public interface CoapDataSender {
    void sendSensorMessage(int numberOfMessages);
}
