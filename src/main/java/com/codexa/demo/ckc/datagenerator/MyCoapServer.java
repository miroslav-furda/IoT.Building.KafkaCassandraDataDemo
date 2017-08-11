package com.codexa.demo.ckc.datagenerator;

import com.codexa.demo.ckc.datagenerator.coap.resources.*;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;


public class MyCoapServer {

    // this runn just once ! by me :)
    // it connects coap://192.168.1.137:5683/

    public static void main(String[] args) {

        CoapServer server = new CoapServer();
        server.add(new WriteSensorDataResource());
        server.start();
    }




























    private void more() {
        // binds on UDP port 5683
        CoapServer server = new CoapServer();

        // "hello"
        server.add(new GrowingResource());

        // "subpath/Another"
        CoapResource path = new CoapResource("subpath");
        path.add(new AnotherResource());
        server.add(path);

        // "removeme!, "time", "writeme!"
        server.add(
                new RemovableResource(),
                new TimeResource(),
                new WritableResource(),
                new WriteSensorDataResource());

        server.start();
    }
}