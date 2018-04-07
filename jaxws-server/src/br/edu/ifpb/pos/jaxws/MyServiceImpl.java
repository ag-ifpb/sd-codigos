package br.edu.ifpb.pos.jaxws;

import java.rmi.RemoteException;

import javax.jws.WebService;




//Adote a seguinte anotação na implementação:
@WebService(
	name="Monitor", 
	serviceName="MonitorService",
	targetNamespace="ag.ifpb", 
	portName="MonitorServicePort"
)
public class MyServiceImpl implements MyService {

	@Override
	public String hello(Message p, String password) throws RemoteException {
	  System.out.println(password);
		return "Olá " + p.getName() + "! Seja bem vindo ao mundo JAX-WS.";
	}

  @Override
  public byte[] helloAsBytes(Message p) throws RemoteException {
    return ("Olá " + p.getName() + "! Seja bem vindo ao mundo JAX-WS.").getBytes();
  }
  
  
	
}
