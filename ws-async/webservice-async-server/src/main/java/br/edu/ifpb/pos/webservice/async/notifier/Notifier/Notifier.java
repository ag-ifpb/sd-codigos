package br.edu.ifpb.pos.webservice.async.notifier.Notifier;

import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "Notifier"
        , targetNamespace = "http://notifier.async.webservice.pos.ifpb.edu.br/")
public interface Notifier {
    
    public boolean notify(String idUser);
}
