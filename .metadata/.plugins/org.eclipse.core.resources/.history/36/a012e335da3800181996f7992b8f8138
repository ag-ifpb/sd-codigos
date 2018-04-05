package ag.ifpb.rmi.iiop;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientMain {

	public static void main(String[] args) throws NamingException, RemoteException {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.cosnaming.CNCtxFactory");
        System.setProperty(Context.PROVIDER_URL,"iiop://localhost:1050");
        Context context=new InitialContext();
        Hello service = (Hello) context.lookup("service");
        service.hello("Ari Garcia");
	}
	
}
