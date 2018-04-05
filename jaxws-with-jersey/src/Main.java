import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {
	
	public static void main(String[] args) throws NotBoundException, UnknownHostException, IOException, ClassNotFoundException {
		//rmi://10.1.1.100:3333/bibliotecaon
		String host = "10.1.1.102";		
		String service = "bibliotecaon";
		Integer port = 3333;
		Registry registry = LocateRegistry.getRegistry(host, port);
		for (String s : registry.list()){
			System.out.println(s);
		}
		Remote obj = registry.lookup(service);
		System.out.println(obj);
	}

}
