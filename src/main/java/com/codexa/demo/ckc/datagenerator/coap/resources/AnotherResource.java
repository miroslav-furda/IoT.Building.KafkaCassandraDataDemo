package com.codexa.demo.ckc.datagenerator.coap.resources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * Created by peter on 9.8.2017.
 */
public class AnotherResource extends CoapResource {


    public AnotherResource() {

        // resource identifier
        super("Another");

        // set display name
        getAttributes().setTitle("Another Hello-World Resource");
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.respond("Fun with CoAP!");
    }
}