package br.edu.ifpb.pos.webservice.async.server;

import br.edu.ifpb.pos.webservice.async.server.productor.Productor;
import javax.xml.ws.Endpoint;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/service", new Productor());
    }
}
