package ag.ifpb.rmi.iiop;

import java.rmi.RemoteException;

import javax.rmi.PortableRemoteObject;


public class HelloServerImpl extends PortableRemoteObject implements Hello{
	
	protected HelloServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void hello(String name) throws RemoteException {
		System.out.println("Hello, " + name); 
	}
	
}
