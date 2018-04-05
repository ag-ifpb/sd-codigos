package ag.ifpb.pod.rmi.heroku;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;

import junit.framework.TestCase;
import sun.rmi.transport.proxy.RMIDirectSocketFactory;
import sun.rmi.transport.proxy.RMIHttpToCGISocketFactory;
import sun.rmi.transport.proxy.RMIHttpToPortSocketFactory;


public class RemoteTest extends TestCase {

	//String url = "/cgi-bin/java-rmi.cgi?forward=";
	//using sun.rmi.transport.proxy.HttpSendSocket
	public void testApp() throws InterruptedException {
		//
		try {
			// RMI over HTTP (by CGI /cgi-bin/java-rmi.cgi?forward=)
			RMISocketFactory.setSocketFactory(new RMIHttpToCGISocketFactory());
			Registry registry = LocateRegistry.getRegistry(
					"ag-rmi-in-heroku.herokuapp.com", 1099, RMISocketFactory.getSocketFactory()
					//"127.0.0.1", 10999, RMISocketFactory.getSocketFactory()
			);
			//
			final HelloWorldRemote remote = (HelloWorldRemote) registry.lookup(HelloWorldRemote.SERVICE_NAME);
			for (String s : registry.list())
				System.out.println(s);
			//
			System.out.println(remote.helloWorld());
			// força bruta... ;)
			for (int i = 0; i < 100; i++) {// com 100 ok, mas com atraso. com
											// 1000 quebra a execução
				Thread thread = new Thread("pod-thread-" + i) {
					@Override
					public void run() {
						try {
							System.out.println(Thread.currentThread().getName() + ": " + remote.helloWorld());
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				};
				thread.start();
			}
			//
			Thread.sleep(5000);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
