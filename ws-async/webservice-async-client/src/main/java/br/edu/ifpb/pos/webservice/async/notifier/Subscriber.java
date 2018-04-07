package br.edu.ifpb.pos.webservice.async.notifier;

import java.net.Socket;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "Subscriber"
        , targetNamespace = "http://notifier.async.webservice.pos.ifpb.edu.br/")
public interface Subscriber {
    
    public Socket subscribe (String hash) throws RemoteException;
}
