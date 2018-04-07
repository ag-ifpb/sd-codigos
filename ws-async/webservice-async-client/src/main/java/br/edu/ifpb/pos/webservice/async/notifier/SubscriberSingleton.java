package br.edu.ifpb.pos.webservice.async.notifier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class SubscriberSingleton {
    
private static Subscriber subscriber = null;

    private SubscriberSingleton() {
    }

    public static Subscriber getInstance() {
        if (subscriber == null) {
            try {
                subscriber = retrieveSubscriber();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return subscriber;
    }

    /**
     * Metodo responsavel por recuperar a instancia do Web Service basico.
     */
    private static Subscriber retrieveSubscriber() throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:9001/subscriber");
        QName qname = new QName("http://notifier.async.webservice.pos.ifpb.edu.br/", "Subscriber");
        Service service = Service.create(url, qname);
        return service.getPort(Subscriber.class);
    }

    
}
