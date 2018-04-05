package ag.ifpb.rmi.raw.server;

import java.rmi.RemoteException;
import ag.ifpb.rmi.raw.shared.Hello;


public class HelloServerImpl implements Hello{
	
	@Override
	public void hello(String name) throws RemoteException {
		System.out.println("Hello, " + name); 
	}
	
}
