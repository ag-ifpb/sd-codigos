package br.edu.ifpb.pos.jaxws.multi;

import java.rmi.RemoteException;

import javax.jws.WebService;

@WebService(serviceName="MyService", portName="port2", targetNamespace="http://multi.jaxws.pos.ifpb.edu.br")
public class ServicePort2Impl implements ServicePort2 {

  @Override
  public void hello2() throws RemoteException {
    System.out.println("Hello 2");
  }

}
