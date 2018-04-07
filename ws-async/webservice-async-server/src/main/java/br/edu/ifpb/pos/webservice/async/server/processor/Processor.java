package br.edu.ifpb.pos.webservice.async.server.processor;

import br.edu.ifpb.pos.webservice.async.server.repository.Repository;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Processor {

    private Map<String, String> toProcess;
    private Queue<String> queue;
    private Repository repository;
    private Thread thread;

    public Processor() {
        this.toProcess = new HashMap<>();
        this.repository = Repository.getInstance();
        this.queue = new LinkedList<>();        
    }

    public void requestProcess(String id, String message) {
//        Thread.sleep(10000);
        if (repository.hasId(id)) {
            toProcess.put(id, message);
            queue.add(id);
        }
        if (thread == null){
            thread = new ProcessThread();
            thread.start();
        }
    }

    private class ProcessThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    while (queue.size() == 0) {
                        this.sleep(1000);
                    }//TODO:resolver
                    String id = queue.poll();
                    String message = toProcess.get(id);
                    message = "Message processed: " + message;
                    toProcess.remove(id);
                    repository.addResponse(id, message);
                    this.sleep(Long.parseLong("" + Math.round(Math.random() * 10000)));
                    // caso a fila esteja vazia, esperar
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
