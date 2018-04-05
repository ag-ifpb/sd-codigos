package ag.ifpb.rmi.raw.server;

import java.rmi.RemoteException;
import java.rmi.server.ObjID;

import sun.rmi.server.UnicastServerRef;
import sun.rmi.transport.LiveRef;


@SuppressWarnings("restriction")
public class App {
	
	public static void main(String[] args) throws RemoteException, InterruptedException {
		//log
		System.out.println("Servidor Iniciando");
		//set hostname
		//System.setProperty("java.rmi.server.hostname", "rmiserver");
		//instance unicast server
		ObjID objID = new ObjID(123);
		LiveRef liveRef = new LiveRef(objID, 10999);
		UnicastServerRef ref = new UnicastServerRef(liveRef);
		//instance object
		HelloServerImpl obj = new HelloServerImpl();
		//instance skeleton
		HelloServerImpl_Skel skel = new HelloServerImpl_Skel();
		//export object (by stub)
		ref.exportObject(obj, skel, true);
		//log
		System.out.println("Servidor Iniciado");
		//gambiarra
		Thread.currentThread().join();
	}
}

