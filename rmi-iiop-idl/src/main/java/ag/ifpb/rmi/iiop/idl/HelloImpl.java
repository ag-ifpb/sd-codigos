package ag.ifpb.rmi.iiop.idl;

import java.rmi.RemoteException;


public class HelloImpl extends ag.ifpb.rmi.iiop.idl.service.HelloPOA{
	
	protected HelloImpl() throws RemoteException {
		super();
	}

	public void hello(String name) {
		System.out.println("Hello, " + name); 
	}
	
}
