package ag.ifpb.rmi.iiop;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{
	void hello(String name) throws RemoteException;
}
