package ag.ifpb.pod.rmi.heroku;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import junit.framework.TestCase;

public class LocalTest extends TestCase {
  
  public void testApp() {
    try {
      Registry registry = LocateRegistry.getRegistry(10999);
      HelloWorldRemote remote = (HelloWorldRemote) registry.lookup(HelloWorldRemote.SERVICE_NAME);
      System.out.println(remote.helloWorld());
    }
    catch(RemoteException e){
      e.printStackTrace();
    } 
    catch (NotBoundException e) {
      e.printStackTrace();
    }
  }
}
