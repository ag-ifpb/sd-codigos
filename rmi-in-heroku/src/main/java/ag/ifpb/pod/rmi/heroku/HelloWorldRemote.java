package ag.ifpb.pod.rmi.heroku;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorldRemote extends Remote {
  String SERVICE_NAME = "__AppService__"; 
  String helloWorld() throws RemoteException;
}
