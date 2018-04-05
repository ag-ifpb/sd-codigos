package ag.ifpb.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;


public class App {
	
	public static void main(String[] args) throws RemoteException, InterruptedException, AlreadyBoundException {
		//log
		System.out.println("Servidor Iniciando");
		//set hostname
		//System.setProperty("java.rmi.server.hostname", "rmiserver");
		//instance unicast server
		Registry registry = LocateRegistry.createRegistry(10999);
		//instance object
		HelloServerImpl obj = new HelloServerImpl();
		//export object (by stub)
		RemoteObject stub = UnicastRemoteObject.exportObject(obj);
		registry.bind("helloService", stub);
		//log
		System.out.println("Servidor Iniciado");
		//gambiarra
		Thread.currentThread().join();
	}
}

