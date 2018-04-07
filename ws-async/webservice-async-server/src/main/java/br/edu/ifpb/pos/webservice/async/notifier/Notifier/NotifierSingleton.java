package br.edu.ifpb.pos.webservice.async.notifier.Notifier;

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
public class NotifierSingleton {

    private static Notifier notifier = null;

    private NotifierSingleton() {
    }

    public static Notifier getInstance() {
        if (notifier == null) {
            try {
                notifier = retrieveNotifier();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return notifier;
    }

    /**
     * Metodo responsavel por recuperar a instancia do Web Service basico.
     */
    private static Notifier retrieveNotifier() throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:9001/notifier");
        QName qname = new QName("http://notifier.async.webservice.pos.ifpb.edu.br/", "Notifier");
        Service service = Service.create(url, qname);
        return service.getPort(Notifier.class);
    }
    
}
