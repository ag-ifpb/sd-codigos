package ag.ifpb.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ag.ifpb.rmi.shared.Hello;


public class App {
	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		//log
		System.out.println("Iniciando o cliente");
		//System.setProperty("java.rmi.server.hostname", "rmiserver");
		System.setProperty("java.rmi.server.codebase", "file:///Volumes/MacintoshHDExt/ari.aula/ifpb.sd/rmi/rmi-with-codebase-client/lib/rmi-with-codebase-server.jar");
		System.setProperty("java.security.policy", "cliente.policy");
		//add security manager
		if (System.getSecurityManager() == null) { 
			System.setSecurityManager(new RMISecurityManager()); 
		}
		//remote reference
		Registry registry = LocateRegistry.getRegistry("localhost", 10999);
		Remote remote = registry.lookup("helloService");
		Hello service = (Hello) remote;
		service.hello("Ari Garcia");
		//log
		System.out.println("Finalizando o cliente");
	}
}
//
//RMISecurityManager manager = new RMISecurityManager();
//manager.checkConnect("localhost", 10999);
//manager.checkConnect("localhost", 10999);

