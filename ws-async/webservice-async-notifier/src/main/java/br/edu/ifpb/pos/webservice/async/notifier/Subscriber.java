package br.edu.ifpb.pos.webservice.async.notifier;

import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.notifier.Subscriber"
        , serviceName = "Subscriber")
public class Subscriber {

    public Socket subscribe (String hash) throws RemoteException{
        try{
            Socket socket = new Socket("127.0.0.1", 9000);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(hash);
            return socket;
        }catch (Exception e){
            throw new RemoteException(e.getMessage());
        }
    }
    
}
