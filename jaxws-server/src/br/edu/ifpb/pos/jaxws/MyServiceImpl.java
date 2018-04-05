package br.edu.ifpb.pos.jaxws;

import java.rmi.RemoteException;

import javax.jws.WebService;




@WebService(
		name = "Hello", //nome do webservice
		serviceName = "HelloService"//, //nome do serviço do webservice,
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