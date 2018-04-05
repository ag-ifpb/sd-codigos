package ag.ifpb.pod.rmi.heroku;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Hello world!
 *
 */
public class Main {
  
  public static void startServer(int port) throws Exception{
    //
    String webappDirLocation = "src/main/webapp";
    //
    WebAppContext root = new WebAppContext();
    root.setContextPath("/");
    root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
    root.setResourceBase(webappDirLocation);
    root.setParentLoaderPriority(true);
    //
    Server server = new Server(port);
    server.setHandler(root);
    server.start();
    server.join();//juntar com a thread principal   
  }
  
  public static void startService(int port) throws RemoteException, AlreadyBoundException{
    //System.setProperty("java.rmi.server.hostname", "localhost");
    Registry registry = LocateRegistry.createRegistry(port);
    registry.bind(HelloWorldRemote.SERVICE_NAME, new HelloWorldRemoteImpl());
  }
  
  public static void main(String[] args) throws Exception {
    //
    Integer rmiPort = 10999;//rmi
    Integer webPort = 80;//http
    //
    String _port = System.getenv("PORT");
    if(_port != null && !_port.isEmpty()) {
        webPort = Integer.parseInt(_port);
    }
    //
    startService(rmiPort);//
    startServer(webPort);//
    //
    //startService(webPort);
  }
}
