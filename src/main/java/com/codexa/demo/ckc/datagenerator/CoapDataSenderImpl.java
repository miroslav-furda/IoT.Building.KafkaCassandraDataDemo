package com.codexa.demo.ckc.datagenerator;


import com.codexa.demo.ckc.datagenerator.coap.CoapDataSender;
import com.codexa.demo.ckc.tocassandra.SensorDataEntity;
import com.codexa.demo.ckc.util.Data;
import org.apache.commons.lang3.SerializationUtils;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * Created by peter on 26.7.2017.
 */
@Service
public class CoapDataSenderImpl implements CoapDataSender {

    private static Logger log = Logger.getLogger("com.codexa.demo.ckc.datagenerator.CoapDataSenderImpl");

    @Value("${coap.server}")
    private String coapServerHost;

    // coap client example
    // https://github.com/Tanganelli/californium/blob/master/api-demo/src/org/eclipse/californium/examples/CoAPClientExample.java

    // leshan client demo
    //https://github.com/eclipse/leshan/tree/master/leshan-client-demo/src/main/java/org/eclipse/leshan/client/demo

    // calfornium get client
    // https://github.com/eclipse/californium/blob/master/demo-apps/cf-helloworld-client/src/main/java/org/eclipse/californium/examples/GETClient.java

    // leshan PDF guide
    // http://openmobilealliance.org/release/LightweightM2M/V1_0-20170208-A/OMA-TS-LightweightM2M-V1_0-20170208-A.pdf


    @Async
    @Override
    public void sendSensorMessage(int numberOfMessages) {

        log.info("sending message");

        CoapClient client = new CoapClient(coapServerHost  + "write-sensor-data");
        //CoapResponse response = client.get();

        log.info("client sends data to = " + client.getURI());

        for (int i = 0; i < numberOfMessages; i++) {

            SensorDataEntity sde = Data.getSensorMessage("type-" + i, "value-" + i, "deviceId-" + i);
            //TODO
            byte[] dataToSend =  new String(
                    sde.getDeviceId() + "," +
                            sde.getTimestamp() + "," +
                            sde.getType() + "," +
                            sde.getValue() + "," +
                            sde.getId()).getBytes();

            CoapResponse response = client.put(dataToSend, i);

                    log.info("Coap Client is putting " + i + " message");
            printResponse(response);
        }
    }



    private static void printResponse(CoapResponse response) {

        if (response!=null) {

            log.info(
                    "- Get code = [" + response.getCode() + "]," +
                            "- Get options = " + response.getOptions() + "]," +
                            "- Response text = " + response.getResponseText() + "]," +
                            "- Is success code = " + (response.isSuccess() ? "OK" : "NOK")  + "]," +
                            "- Get code = " + (response.getCode() == CoAP.ResponseCode.CHANGED ? "PUT OK" : "PUT NOK")
            );

        } else {
            System.out.println("- Request failed");
        }
    }
}