package br.edu.ifpb.pos.webservice.async.server.productor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Classe que implementa o padrão singleton para o acesso à instância da interface
 * do Web Service básico.
 * 
 * @author douglasgabriel
 * @version 0.1
 */
public class ProductorSingleton {

    private static Productor productor = null;

    private ProductorSingleton() {
    }

    public static Productor getInstance() {
        if (productor == null) {
            try {
                productor = retrieveProductor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productor;
    }

    /**
     * Metodo responsavel por recuperar a instancia do Web Service basico.
     */
    private static Productor retrieveProductor() throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/service");
        QName qname = new QName("http://productor.server.async.webservice.pos.ifpb.edu.br/", "Productor");
        Service service = Service.create(url, qname);
        return service.getPort(Productor.class);
    }

}
