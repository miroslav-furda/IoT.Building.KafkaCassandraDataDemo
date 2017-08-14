package com.codexa.demo.ckc.datagenerator.coap.resources;

import com.codexa.demo.ckc.tocassandra.SensorDataEntity;
import com.codexa.demo.ckc.util.Data;
import org.apache.commons.lang3.SerializationUtils;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.BAD_REQUEST;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CHANGED;

/**
 * Created by peter on 9.8.2017.
 */
public class WriteSensorDataResource extends CoapResource {

    public SensorDataEntity data = Data.getSensorMessage("dummy", "dummy", "dummy");

    private long counter = 0;

    public WriteSensorDataResource() {
        super("write-sensor-data");
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond(CoAP.ResponseCode.CONTENT, SerializationUtils.serialize(data));
        System.out.println("handleGET responds with " + data);
    }

    @Override
    public void handlePUT(CoapExchange exchange) {

        byte[] payload = exchange.getRequestPayload();

        try {
            //data = SerializationUtils.deserialize(payload);
            exchange.respond(CHANGED, payload);
            exchange.getRequestText();
            System.out.println("From server : yes i see your PUT " + (++counter) + "= " + payload);
        } catch (Exception e) {
            e.printStackTrace();
            exchange.respond(BAD_REQUEST, "Invalid sensor data");
            System.out.println("From server : your PUIT is wrong !");
        }
    }

    //TODO put
}