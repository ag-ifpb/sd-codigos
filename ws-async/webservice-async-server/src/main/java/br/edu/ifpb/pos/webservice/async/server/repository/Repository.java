package br.edu.ifpb.pos.webservice.async.server.repository;

import br.edu.ifpb.pos.webservice.async.notifier.Notifier.NotifierSingleton;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Repository {

    private List<String> identities;
    private Map<String, String> responses;
    private static Repository instance;

    private Repository() {
        this.identities = new ArrayList<>();
        this.responses = new HashMap<>();
    }
    
    public static Repository getInstance (){
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }

    public String getNewIdentity() {
        String id = generateId();
        identities.add(id);
        return id;
    }
    
    public boolean hasId (String id){
        return this.identities.contains(id);
    }
    
    public void addResponse (String id, String message){
        this.responses.put(id, message);
        new NotifyThread(id).start();
    }        
    
    public String getResponse (String id){
        String response = null;
        if (responses.containsKey(id)){            
            response = responses.get(id);
            responses.remove(id);
        }
        return response;
    }

    private String generateId() {
        try {
            return Base64.getEncoder().encodeToString(
                    MessageDigest.getInstance("MD5").digest(
                            ("" + System.currentTimeMillis()).getBytes()
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    
    private class NotifyThread extends Thread{

        private String id;
        
        public NotifyThread (String id){
            this.id = id;
        }
        
        @Override
        public void run() {
            while (!NotifierSingleton.getInstance().notify(id)){
                try {
                    this.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        
    }

}
