package br.edu.ifpb.pos.webservice.async.notifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "br.edu.ifpb.pos.webservice.async.notifier.Notifier", serviceName = "Notifier")
public class Notifier {

    private static Map<String, PrintWriter> toNofify = new HashMap<>();

    public boolean notify(String idUser) {
        if (!toNofify.containsKey(idUser)) {
            return false;
        }
        toNofify.get(idUser).println(true);
        return true;
    }

    public static void enableSubscribe() throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true) {
            Socket client = server.accept();
            String idUser = new BufferedReader(new InputStreamReader(client.getInputStream())).readLine();
            toNofify.put(idUser, new PrintWriter(client.getOutputStream(), true));
        }
    }

}
