package ag.ifpb.pod.rmi.heroku;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class HelloWorldRemoteImpl extends UnicastRemoteObject implements HelloWorldRemote {

  protected HelloWorldRemoteImpl() throws RemoteException {
    super();
  }

  public String helloWorld() throws RemoteException {
    return "Hello World";
  }

}
