package br.edu.ifpb.pos.webservice.async.client;

import br.edu.ifpb.pos.webservice.async.server.productor.Productor;
import br.edu.ifpb.pos.webservice.async.server.productor.ProductorSingleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException, RemoteException, IOException {
    	//
        Productor service = ProductorSingleton.getInstance();
        //
        String id = service.registry();
        //
        Socket socket = new Socket("127.0.0.1", 9000);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(id);
        service.request(id, "Qualquer");
        System.out.println("Passou do request");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String subscriberResponse = reader.readLine();
        //
        if (subscriberResponse.equals("true")) {
            System.out.println(service.recover(id));//recuperação
        }
        //
//        while (true){
//            Thread.sleep(100);
//            String response = service.recover(id);
//            if (response != null && !response.isEmpty()){
//                System.out.println(response);
//                break;
//            }
//            System.out.println("Sem resposta");
//        }
    }
}
