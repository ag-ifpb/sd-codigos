package ag.ifpb.rmi.server;

import java.rmi.RemoteException;
import ag.ifpb.rmi.shared.Hello;


public class HelloServerImpl implements Hello{
	
	@Override
	public void hello(String name) throws RemoteException {
		System.out.println("Hello, " + name); 
	}
	
}
