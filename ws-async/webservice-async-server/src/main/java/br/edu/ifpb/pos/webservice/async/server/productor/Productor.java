package br.edu.ifpb.pos.webservice.async.server.productor;

import br.edu.ifpb.pos.webservice.async.server.processor.Processor;
import br.edu.ifpb.pos.webservice.async.server.repository.Repository;
import javax.jws.Oneway;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.server.productor.Productor", serviceName = "Productor")
public class Productor {

    private Repository repository;
    private Processor processor;

    public Productor() {
        this.repository = Repository.getInstance();
        this.processor = new Processor();
    }

    public String registry() {
        String id = repository.getNewIdentity();
        System.out.println(id);
        return id;
    }

    @Oneway
    public void request(String id, String message) {
        try {
            Thread.sleep(10000);//representar um processamento longo
        } catch (Exception e) {
            e.printStackTrace();
        }
        processor.requestProcess(id, message);
    }

    public String recover(String id) {
        return repository.getResponse(id);
    }

}
