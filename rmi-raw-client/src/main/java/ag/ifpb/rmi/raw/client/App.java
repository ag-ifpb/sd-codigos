package ag.ifpb.rmi.raw.client;

import java.rmi.RemoteException;
import java.rmi.server.ObjID;

import sun.rmi.server.UnicastRef;
import sun.rmi.transport.LiveRef;


@SuppressWarnings("restriction")
public class App {
	public static void main(String[] args) throws RemoteException {
		//log
		System.out.println("Iniciando o cliente");
		//set hostname
		//System.setProperty("java.rmi.server.hostname", "rmiserver");
		//remote reference
		ObjID objID = new ObjID(123);
		LiveRef liveRef = new LiveRef(objID, 10999);
		UnicastRef ref = new UnicastRef(liveRef);
		//instance stub and run hello
		HelloServerImpl_Stub stub = new HelloServerImpl_Stub(ref);
		stub.hello("Ari Garcia");
		//log
		System.out.println("Finalizando o cliente");
	}
}

