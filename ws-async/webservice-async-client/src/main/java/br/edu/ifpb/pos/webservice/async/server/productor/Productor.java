package br.edu.ifpb.pos.webservice.async.server.productor;

import javax.jws.Oneway;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 */
@WebService(name = "Productor"
        , targetNamespace = "http://productor.server.async.webservice.pos.ifpb.edu.br/")
public interface Productor {
    
    public String registry ();
    
    @Oneway
    public void request (String id, String message);
    
    public String recover(String id);
    
}
